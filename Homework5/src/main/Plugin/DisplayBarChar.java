package main.Plugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ac.essex.graphing.charts.discrete.BarChartPlot;
import main.framework.Framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;


public class DisplayBarChar implements DisplayPlugin {
    Framework framework;
    Map<String, Double> map;
    Map<String, Double> sortedMap;
    
    @Override
    public void setFramework(Framework framework) {
        this.framework = framework;

    }

    @Override
    public void setMap(Map<String, Double> map, Map<String, Double> sortedMap) {
        this.map = map;
        this.sortedMap = sortedMap;
    }
    
    @Override
    public JComponent display() {
        BarChartComponent component = new BarChartComponent(map);
        return component;
    }
    

    
    @Override
    public JPanel disPlaySort() {
        DisplaySortPanel displaySortPanel = new DisplaySortPanel(sortedMap);
        return displaySortPanel;

    }

    @Override
    public String getTitle() {
        return "Data Distribution - Bar Graph";
    }

}
