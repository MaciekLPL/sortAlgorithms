package pl.lejczak.project.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * BarChart reprezentation used in GUI
 * @author Maciej Lejczak
 * @version 1.0
 */
public class BarChart extends JPanel{

    private ArrayList<Integer> list;

    private int chartWidth, chartHeight;


    public BarChart(ArrayList<Integer> list) {
        super();
        this.list = list;
    }

    public void updateList(ArrayList<Integer> list) {
        this.list = list;
    }
    
    @Override
    public void paintComponent(Graphics g) {

        chartWidth = this.getWidth();
        chartHeight = this.getHeight(); 
               
        Graphics2D g2 = (Graphics2D) g;
        drawBars(g2);
    }

    public void drawBars(Graphics2D g2) {

        Color original = g2.getColor();

        double numBars = list.size();
        double max = list.get(0);
        double min = list.get(0);

        for (Integer c : list) {
            if (max < c)
                max = c;
            if (min > c)
                min = c;
        }
        if (abs(min) > max) {
            max = abs(min);
        }
        
        int barWidth = (int) (chartWidth / numBars);
        int counter = 0;
        
        for (Integer i : list){

            double height2 = (i / max) * ((chartHeight / 2)  - 10);
            int height = (int) height2;
            int xLeft = counter * barWidth;
            g2.setColor(Color.RED);
            
            if (i > 0) {
                int yTopLeft = (chartHeight / 2) - height;
                g2.drawRect(xLeft, yTopLeft, barWidth, height);
                g2.drawString(i.toString(), (xLeft), (yTopLeft));
            }
            else {
                int yTopLeft = (chartHeight / 2);
                g2.drawRect(xLeft, yTopLeft, barWidth, abs(height));
                g2.drawString(i.toString(), xLeft, yTopLeft);
            }
            
            counter++;
        }
        g2.setColor(original);
    }
}
