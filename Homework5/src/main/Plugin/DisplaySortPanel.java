package main.Plugin;

import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplaySortPanel extends JPanel{

    private JLabel[] sortedRest;
    private Map<String, Double> map;
    
    public DisplaySortPanel(Map<String, Double> map) {
        sortedRest = new JLabel[20];
        this.map = map;
        
        int index = 0;
        int length = Math.min(10, map.size());
        
//        this.setLayout(new BoxLayout(this.getRootPane(), BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(10, 2));
        for (String key : map.keySet()) {
            if (index > length) {
                break;
            }
            sortedRest[index] = new JLabel("Name:  " + key);
            this.add(sortedRest[index++]);
            sortedRest[index] = new JLabel("Stars:   " + map.get(key).toString());
            this.add(sortedRest[index++]);
            
            this.setVisible(true);
        }
    }
    
}
