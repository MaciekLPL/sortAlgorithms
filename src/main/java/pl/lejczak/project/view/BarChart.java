package pl.lejczak.project.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/**
 * BarChart representation used in GUI
 * @author Maciej Lejczak
 * @version 1.0
 */
public class BarChart extends JPanel{

    private ArrayList<Integer> list;
    private int chartWidth, chartHeight, barHeight;
    static final int MARGIN = 10;

    public BarChart(ArrayList<Integer> list) {
        super();
        this.list = list;
    }

    public void updateList(ArrayList<Integer> list) {
        this.list = list;
    }
    
    @Override
    public void paintComponent(Graphics g) {

        chartWidth = this.getWidth() - MARGIN;
        chartHeight = this.getHeight() - MARGIN; 
               
        Graphics2D g2 = (Graphics2D) g;
        drawBars(g2);
    }

    public void drawBars(Graphics2D g2) {

        Color original = g2.getColor();

        double numBars = list.size();
        double max = calcHeight();
        
        int barWidth = (int) (chartWidth / numBars);
        int counter = 0;
        
        for (Integer i : list){

            int height = (int) ((i / max) * barHeight);
            int xLeft = counter * barWidth;
            int yTopLeft = barHeight + MARGIN;
            
            if (i > 0) {                //negative values drawn from x axis
                yTopLeft -= height;     
            }
            
            g2.setColor(Color.darkGray);
            g2.drawRect(xLeft, yTopLeft, barWidth, abs(height));
            g2.drawString(i.toString(), xLeft, yTopLeft);
            counter++;
        }
        g2.setColor(original);
    }
    
    
    public double calcHeight() {
        
        double max = Collections.max(list);
        double min = Collections.min(list);
    
        barHeight = min >= 0 ? chartHeight - MARGIN : (chartHeight / 2) - MARGIN;
        
        if (abs(min) > max) {
            max = abs(min);
        }
        
        return max;
    }   
}
