package main.Plugin;

import java.util.Map;

import main.framework.Framework;

public interface DataPlugin {
    
    void setFramework(Framework framework);
    /**
     * 
     * @param source input local filename or web URL
     */
    void parseSource(String source);
    
    Map<String, Double> getMap();
    
    Map<String, Double> getSortedMap();
    
}
