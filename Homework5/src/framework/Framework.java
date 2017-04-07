package framework;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Plugin.DataPlugin;
import Plugin.DisplayPlugin;

public class Framework extends JFrame{
    private DataPlugin dataPlugin;
    private DisplayPlugin displayPlugin;
    private Map<String, Integer> map;
    private JPanel jpanel;
    
    public Framework(DataPlugin dataPlugin, DisplayPlugin displayPlugin) {
        this.dataPlugin = dataPlugin;
        this.displayPlugin = displayPlugin;
        this.dataPlugin.setFramework(this);
        this.displayPlugin.setFramework(this);
        
    }
    // realize the JFrame
    public void initial() {
        
        
    }
    // get the JPnael from Display plugin, and show it in the JFrame
    public JPanel getDisaplay() {
        //TODO
        
        return displayPlugin.display(map);
    }
    
    
}
