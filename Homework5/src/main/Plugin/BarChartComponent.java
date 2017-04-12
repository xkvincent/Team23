package main.Plugin;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class is used to set the height of each bar.
 * @author xuvincent
 *
 */
public class BarChartComponent extends JComponent {
    Map<String, Double> map;
    Map<Integer, Integer> starFreq;
    
    BarChartComponent(Map<String, Double> map) {
        this.map = map;
        
        starFreq = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            starFreq.put(i, 0);
        }
        calculateFrequency();
    }
    //把Map中的star给分级存在starFreq
    private void calculateFrequency() {
        for(String key: map.keySet()) { //遍历map
            double star = map.get(key);
//            System.out.println(star);
            int value = 1;
            if (star >= 4.0) {
//                if (starFreq.containsKey(4)) {
//                    value = starFreq.get(4) + 1;
//                }
//                starFreq.put(4, value);
                starFreq.put(4, starFreq.get(4) + 1);
            } else if (star >= 3.0) {
//                if (starFreq.containsKey(3)) {
//                    value = starFreq.get(3) + 1;
//                }
//                starFreq.put(3, value);
                starFreq.put(3, starFreq.get(3) + 1);
            } else if (star >= 2.0) {
//                if (starFreq.containsKey(2)) {
//                    value = starFreq.get(2) + 1;
//                }
//                starFreq.put(2, value);
                starFreq.put(2, starFreq.get(2) + 1);
            } else if (star >= 1.0) {
//                if (starFreq.containsKey(1)) {
//                    value = starFreq.get(1) + 1;
//                }
//                starFreq.put(1, value);
                starFreq.put(1, starFreq.get(1) + 1);
            } else if (star >= 0) {
//                if (starFreq.containsKey(0)) {
//                    value = starFreq.get(0) + 1;
//                }
//                starFreq.put(0, value);
                starFreq.put(0, starFreq.get(0) + 1);
            } 
        }
    }
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
//      BarChart c = new BarChart(getWidth(), getHeight());
      BarChart c = new BarChart(400, 400);
      // 需要通过对Map数据的操作，设置下面的add()
      for (int key : starFreq.keySet()) {
//          System.out.println(starFreq.get(key));
          c.add(starFreq.get(key) );
      }
//      c.add(2.0);
//      c.add(1.5);
//      c.add(2.0);
//      c.add(3.0);
//      c.add(2.1);
//      c.add(2.7);
//      c.add(2.6);
      c.draw(g2);
   }
}
