package Plugin;

import ac.essex.graphing.plotting.Graph; 
import ac.essex.graphing.plotting.PlotSettings; 
import ac.essex.graphing.swing.GraphApplication; 
import ac.essex.graphing.charts.continuous.Circle1; 
import ac.essex.graphing.charts.continuous.SineWave; 
import ac.essex.graphing.charts.discrete.CandleStickPlot; 
import ac.essex.graphing.charts.discrete.BarChartPlot; 
 
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame; 
 
/** 
 * Demonstrates how to display a graph using JavaPlot. 
 * 
 * <p> 
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation; either version 2 
 * of the License, or (at your option) any later version, 
 * provided that any use properly credits the author. 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details at http://www.gnu.org 
 * </p> 
 * 
 */ 
public class Test2 { 
 
    public static void main(String[] args) { 
 
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("BarChart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //        BarChartComponent component = new BarChartComponent();
       
//        frame.add(component);

        Map<String, Double> map = new HashMap<>();
        map.put("test1", 1.5);
        map.put("test2", 2.0);
        map.put("test3", 2.5);
        map.put("test4", 3.5);
        map.put("test5", 4.0);
        map.put("test6", 4.5);
        map.put("test7", 4.5);
        
        
        Display2 display2 = new Display2();
        display2.setMap(map);
        frame.add(display2.disPlayGraph());
        
        frame.setVisible(true);
 
    } 
 
    
 
} 