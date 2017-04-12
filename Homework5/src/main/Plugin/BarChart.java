package main.Plugin;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;

/**
 * This class is used to actually draw the graph.
 * @author xuvincent
 *
 */
public class BarChart {
   private int width;
   private int height;
   private ArrayList<Double> data;

   public BarChart(int aWidth, int aHeight) {
      width = aWidth;
      height = aHeight;
      data = new ArrayList<Double>();
   }

   public void add(double value) {
      data.add(value);
   }

   public void draw(Graphics2D g2) {
      int i = 0;
      double max = 0;
      //得到data中的max值
      for (Double wrapper : data) {
         if(max < wrapper)
            max = wrapper;
      }

      int xwidth = width - 1;
      int yheight = height - 1;

      int xleft = 0;
      //计算并画出各个data的高度
      for (i = 0; i < data.size(); i++) {
         int xright = xwidth * (i + 1) / data.size();
         int barWidth = xwidth / data.size();
         int barHeight = (int) Math.round(yheight * data.get(i) / max);

         Rectangle bar =
            new Rectangle(xleft, yheight - barHeight,
               barWidth, barHeight);
         g2.draw(bar);
         
         //画text
         g2.drawString("0-1 star",20,410);
         g2.drawString("1-2 star",100, 410);
         g2.drawString("2-3 star",180, 410);
         g2.drawString("3-4 star",260, 410);
         g2.drawString("4-5 star",340, 410);
         
         xleft = xright;
      }
   }
}
