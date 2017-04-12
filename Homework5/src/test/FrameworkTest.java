package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.xml.crypto.Data;

import org.junit.Test;

import main.Plugin.DataPlugin;
import main.Plugin.DataWeb;
import main.Plugin.DisplayBarChar;
import main.Plugin.DisplayPlugin;
import main.framework.Framework;

public class FrameworkTest {

    JFrame frame;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    
    public void setUp () {
        frame = new JFrame();
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("BarChart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Map<String, Double> map = new HashMap<>();
        map.put("test1", 1.5);
        map.put("test2", 2.0);
        map.put("test3", 2.5);
        map.put("test4", 3.5);
        map.put("test5", 4.0);
        map.put("test6", 4.5);
        map.put("test7", 4.5);
        
        
 
    }
    
    @Test
    public void testDisplay2() {
        DisplayBarChar display2 = new DisplayBarChar();
        DataPlugin dataPlugin = new DataWeb();
        DisplayPlugin displayPlugin = new DisplayBarChar();
        Framework framework = new Framework(dataPlugin, displayPlugin, 
                "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Pittsburgh%2C+PA&ns=1");  
        
          frame.add(display2.display());
          frame.add(display2.disPlaySort());
          frame.setVisible(true);
          frame.pack();
    }

}
