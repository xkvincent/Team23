package framework;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Plugin.DataPlugin;
import Plugin.DisplayPlugin;

public class Framework extends JFrame{
    private DataPlugin dataPlugin;
    private DisplayPlugin displayPlugin;
    private Map<String, Double> map;
    private JPanel jpanel;
    
    
    public Framework(DataPlugin dataPlugin, DisplayPlugin displayPlugin, String source) {
        this.dataPlugin = dataPlugin;
        this.displayPlugin = displayPlugin;
        
        this.dataPlugin.setFramework(this);
        this.displayPlugin.setFramework(this);
        
        dataPlugin.parseSource(source); // user input
        

        displayPlugin.setMap(dataPlugin.getMap());
        
        
        this.add(getDisaplay());
        this.add(getSortDisaplay()); // right Jpanel
        setVisible(true);
        
    }
//    // realize the JFrame
//    public void initial() {
//        
//        
//    }
    // get the JPnael from Display plugin, and show it in the JFrame
    public JComponent getDisaplay() {
        return this.displayPlugin.display();

    }
    public JPanel getSortDisaplay() {
        return this.displayPlugin.disPlaySort();

    }
    
    
}
