package main.Plugin;

import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplaySortStar extends JPanel{

    private JLabel[] sortedRest;
    private Map<Double, Integer> map;
    
    public DisplaySortStar(Map<Double, Integer> starBins) {
        sortedRest = new JLabel[22];
        this.map = starBins;
        
        int index = 0;
//        int length = 22;

        this.setLayout(new GridLayout(11, 2));
        for (Double key : map.keySet()) {
//            if (index > length) {
//                break;
//            }
            sortedRest[index] = new JLabel("Stars:  " + key);
            this.add(sortedRest[index++]);
            sortedRest[index] = new JLabel("Count:   " + map.get(key).toString());
            this.add(sortedRest[index++]);
            
            this.setVisible(true);
        }
    }
    
}
