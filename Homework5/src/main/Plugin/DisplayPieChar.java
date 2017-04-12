package main.Plugin;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import main.framework.Framework;

public class DisplayPieChar implements DisplayPlugin {
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
        PieGraphComponent component = new PieGraphComponent(map);
        return component;
    }

    @Override
    public JPanel disPlaySort() {
        PieGraphComponent component = new PieGraphComponent(map);
        DisplaySortStar displaySortPanel = new DisplaySortStar(component.getStarBins());
        return displaySortPanel;
    }

    @Override
    public String getTitle() {
        return "Data Distribution - Pie Chart";
    }

}
