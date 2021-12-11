package pl.lejczak.project.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/**
 * Used to print informations in console.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class View {
    
    private JFrame frame;
    private BarChart chart;
    
    private JButton startBtn;
    private JButton resetBtn;
    
    private JRadioButton bubbleRadio;
    private JRadioButton insertionRadio;
    
    private ButtonGroup buttonGroup;
    
    
    public void initView(ArrayList<Integer> data) {
        frame = new JFrame("Sort algorithms visualisation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        startBtn = new JButton("Start");
        resetBtn = new JButton("Reset");
        
        topPanel.add(startBtn);
        topPanel.add(resetBtn);
        contentPane.add(topPanel, BorderLayout.PAGE_START);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        bubbleRadio = new JRadioButton("Bubble Sort");
        bubbleRadio.setActionCommand("Bubble Sort");
        bubbleRadio.setSelected(true);
        
        insertionRadio = new JRadioButton("Insertion Sort");
        insertionRadio.setActionCommand("Insertion Sort");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(bubbleRadio);
        buttonGroup.add(insertionRadio);
        
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(bubbleRadio);
        leftPanel.add(insertionRadio);
        leftPanel.add(Box.createVerticalGlue());
        contentPane.add(leftPanel, BorderLayout.LINE_START);
        
        chart = new BarChart(data);
        contentPane.add(chart, BorderLayout.CENTER);
        
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setSize(800, 800);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    public void repaint(ArrayList<Integer> data) {
        chart.updateList(data);
        frame.repaint();
    }
    
    /**
     * Prints message passed as parameter in the console.
     * @param message message to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
    
    public String askForNumbers() {
        return JOptionPane.showInputDialog("Input numbers to sort");
    }
    
    
    public JButton getStartBtn() {
        return startBtn;
    }
    
    public JButton getResetBtn() {
        return resetBtn;
    }
    
    public JRadioButton bubbleRadioBtn() {
        return bubbleRadio;
    }
    
    public JRadioButton insertionRadioBtn() {
        return insertionRadio;
    }
    
    public String getSelectedButton() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getActionCommand();
            }
        }
        return null;
    }
    
    public void disableWhenSorting() {
        startBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        bubbleRadio.setEnabled(false);
        insertionRadio.setEnabled(false);
    }
    
    public void enableAfterSorting() {
        startBtn.setEnabled(true);
        resetBtn.setEnabled(true);
        bubbleRadio.setEnabled(true);
        insertionRadio.setEnabled(true);
    }
}
