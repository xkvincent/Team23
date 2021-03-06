package main.Plugin;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import main.framework.Framework;

public interface DisplayPlugin {
    void setFramework(Framework main);
    
    void setMap(Map<String, Double> map, Map<String, Double> sortedMap);
    /**
     * create JPnael according to the input map.
     * @return Panel
     */
    JComponent display();
    /**
     * create another meaningful JPanel
     * @return Panel
     */
    JPanel disPlaySort();
    String getTitle();
    
    
}
