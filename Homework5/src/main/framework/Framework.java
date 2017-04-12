package main.framework;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import main.Plugin.DataPlugin;
import main.Plugin.DisplayPlugin;

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
       
        displayPlugin.setMap(dataPlugin.getMap(), dataPlugin.getSortedMap());
        
        
        JFrame frame = new JFrame("Data Visualization");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(getDisaplay());
        panel.add(getSortDisaplay()); // right Jpanel
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.setSize(1150,500);
        frame.setVisible(true);
        
    }

    // get the JPnael from Display plugin, and show it in the JFrame
    public JComponent getDisaplay() {
        return this.displayPlugin.display();

    }
    public JPanel getSortDisaplay() {
        return this.displayPlugin.disPlaySort();

    }
    
    
}
