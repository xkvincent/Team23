package plugA;

import framework.Plugin;


public class PluginA implements Plugin {
    @Override
    public void doSomething() {
        System.out.println("pluginA executed.");
    }
}
