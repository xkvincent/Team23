package framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Framework {

    public static void main(String[] args) {

        URL[] jars = findPluginJars();
        ClassLoader cl = new URLClassLoader(jars, Thread.currentThread().getContextClassLoader());
        Iterator<Plugin> plugins = ServiceLoader.load(Plugin.class, cl).iterator();


        System.out.println("Plugins: ");
        while (plugins.hasNext())
            plugins.next().doSomething();

    }

    private static URL[] findPluginJars() {

        File pluginsDir = new File("plugins");
        if (!pluginsDir.exists() || !pluginsDir.isDirectory()) {
            System.err.println("plugins/ directory not found");
            return new URL[0];
        }
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

}
