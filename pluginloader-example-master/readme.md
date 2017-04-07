# Plugin Loading

Loading plugins from different sources without any changes to the framework
can be a little confusing. We recommend the following design:

## Project layout and dependencies

You will have a project for the framework and one or more projects
for the plugins. The framework project contains the main starter
code, the plugin interface, and of course the framework code.

```
/hw5/framework
/hw5/pluginA
/hw5/pluginB
```

The plugin projects will depend on the framework project.


### Manual dependency management (Gradle)

In the plugin directories create a `settings.gradle` file
```
include '..:framework'
```

In the plugin's `build.gradle` file include the dependency
as
```gradle
dependencies {
    compile project(":..:framework")
}
```

Now gradle builds in the plugin project will have access
to the types of the framework project.
Using absolute paths instead of relative ones is possible.

It is also possible to create a jar file with `gradle jar`
and manage a dependency on that jar, but the jar file would
have to be recreated on every change.

### Automated dependency management

A cleaner approach is to push the jar to a repository from
where other projects can download it. For part C of the
homework, we will host all selected projects in such a
repository.

For this to work, the **framework project** needs a groupID, a
name and a version.

Set the name in `hw5/framework/settings.gradle`:
```
rootProject.name = 'frameworkName'
```

Set the group and version as well as the repository URL in `hw5/framework/build.gradle`:
```gradle
apply plugin: 'maven'

group = 'cs15214'

version = '0.5.1'

uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: "<REPOSITORYURL>")
        }
    }
}
```

For testing, a local path will be sufficient for the URL, eg. `"file:///tmp/deploy`

Now you can build a jar and push it to the repository using `gradle uploadArchives`



In the **plugin projects**, you will need to define the path to the repository
and the dependency in your    `hw5/plugin../build.gradle`:
```gradle
repositories {
    mavenCentral()
    maven {
        url "<REPOSITORYURL>"
    }
}

dependencies {
    compile group: "cs15214", name: "frameworkName", version: '0.5.1'
}
```

Here group, name, and version refer to the name of the published framework above.
Gradle will now automatically download the dependency on a build.

Note that this won't work on Travis-CI unless you publish the resources
to a repository that is visible from the web.
We recommend to use manual dependency management for part B.


## Loading Plugins

We assume you have a plugin interface `path.Plugin` (supporting multiple
different plugin interfaces is done the same way) and a main class
in the framework project. The plugin projects will provide one or more
implementations of that interface.

To start the framework with the plugins, both framework and plugins must
be in the classpath. In addition, the framework needs to know which
classes are plugin implementations. We use the `java.util.ServiceLoader`
class and its conventions:

Each plugin project must have a `META-INF/services/path.Plugin` text
 file that contains the name of all classes implementing the plugin
 interface. This file must be in the resource directory, that is
 `hw5/pluginA/src/main/resources/META-INF/services/path.Plugin`
 (if you are using an IDE, make sure that the resources directory
 is configured as resources)

The following code will now load all plugins in the classpath that
have been mentioned in the META-INF configuration files:
```java
   Iterator<Plugin> plugins = ServiceLoader.load(Plugin.class).iterator();
```

The plugins can be found if the framework is started from the plugin
project (e.g., add `apply plugin: 'application'` and `mainClassName = "framework.Framework"`
to the plugin's `build.gradle` file and start with `gradle run`) or if the classes of
both framework and plugin project are
provided explicitly as part of the classpath, e.g.:
```
java -cp ../framework/build/libs/frameworkA-0.0.1.jar:build/libs/plugin.jar framework.Framework
```

### Loading plugins from .jar files

Additionally, it is possible to search for plugins in jar files a specific directory.
The plugin jar files are created with `gradle jar` in the plugin projects. It is
still necessary to create the META-INF file.

The framework code can now look for plugins in `plugins/*.jar` files as follows:
```java
   private static URL[] findPluginJars() throws MalformedURLException {
        //where to search
        File pluginsDir = new File("plugins");
        if (!pluginsDir.exists() || !pluginsDir.isDirectory()) {
            System.err.println("plugins/ directory not found");
            return new URL[0];
        }
        //find all jars and convert to URL array
        return Arrays.stream(new File("plugins").listFiles()).
                filter(file -> file.getName().toLowerCase().endsWith(".jar")).
                map(file -> {
                    try {
                        return file.toURI().toURL();
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }).
                toArray(URL[]::new);
    }


     URL[] jars = findPluginJars();
     //create a class loader that searches in these extra jar files
     ClassLoader cl = new URLClassLoader(jars, Thread.currentThread().getContextClassLoader());
     //use service loader with extra classloader
     Iterator<Plugin> plugins = ServiceLoader.load(Plugin.class, cl).iterator();
```











