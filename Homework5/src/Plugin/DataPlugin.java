package Plugin;

import java.util.Map;

import framework.Framework;

public interface DataPlugin {
    
    void setFramework(Framework framework);
    /**
     * 
     * @param source input local filename or web URL
     */
    void parseSource(String source);
    
    Map<String, Integer> getMap();
    
}
