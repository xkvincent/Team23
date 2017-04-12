package main.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PieGraphComponent extends JComponent{
	private Map<String, Double> mappy;
	private HashMap<Double, Integer> starBins;
	private double[] starsTypes = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0};
	private Color[] starsColors = {Color.YELLOW, Color.BLUE, Color.CYAN, Color.BLACK, Color.DARK_GRAY, Color.GREEN, 
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.BLUE};
	
	public PieGraphComponent(Map<String, Double> mappy) {
		this.mappy = mappy;
		starBins = new HashMap<Double, Integer>();
		
		for (double i : starsTypes) {
			starBins.put(i, 0);
		}
		splitBins();
	}

	private void splitBins() {
		for(String key: mappy.keySet()) {
			double score = mappy.get(key);
			double score2 = (double) (int) score;
			starBins.put(score2, starBins.get(score2) + 1);
		}
	}
	
	
	public void paint(Graphics g) {
		double total = 0.0;
		for (double starT: starBins.keySet()) {
			total += starBins.get(starT);
		}
		
		double curve = 0.0D;
		int origin = 0;
		for (int i = 0; i < starBins.size(); i++) {
			origin = (int) (curve * 360 / total);
			int angle = (int) (starBins.get(starsTypes[i]) * 360 / total);
			g.setColor(starsColors[i]);
			g.fillArc(getBounds().x + 20, getBounds().y + 20, getBounds().width / 2, getBounds().height - 40, origin, angle);
			curve += starBins.get(starsTypes[i]);
		}
	  }
	
	public HashMap<Double, Integer> getStarBins() {
		return starBins;
	}

}
