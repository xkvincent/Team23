package Plugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ac.essex.graphing.charts.discrete.BarChartPlot;
import framework.Framework;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Display2 implements DisplayPlugin {
    Framework framework;
    Map<String, Double> map;
    
    @Override
    public void setFramework(Framework framework) {
        this.framework = framework;

    }

    @Override
    public void setMap(Map<String, Double> map) {
        this.map = map;
        
    }

    @Override
    public JPanel display() {
        JPanel jPanel = new JPanel();
        
//        BarChartComponent component = new BarChartComponent();
//        return component;
        
        return jPanel;
    }
    
    public JComponent disPlayGraph() {
        BarChartComponent component = new BarChartComponent(map);
        return component;
    }
    

    
    @Override
    public JPanel disPlaySort() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }

}
