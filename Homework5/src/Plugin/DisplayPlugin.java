package Plugin;

import java.util.Map;

import javax.swing.JPanel;

import framework.Framework;

public interface DisplayPlugin {
    void setFramework(Framework main);
    
    void setMap(Map<String, Double> map);
    /**
     * create JPnael according to the input map.
     * @return Panel
     */
    JPanel display();
    /**
     * create another meaningful JPanel
     * @return Panel
     */
    JPanel disPlaySort();
    String getTitle();
    
    
}
