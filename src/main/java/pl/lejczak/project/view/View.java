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
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * GUI class
 * @author Maciej Lejczak
 * @version 1.0
 */
public class View {
    /** Main frame */
    private JFrame frame;
    /** Bar chart for visualization */
    private BarChart chart;
    /** Start button */
    private JButton startBtn;
    /** Pause button */
    private JButton pauseBtn;
    /** Reset button */
    private JButton resetBtn;
    /** Bubble sort radio button */
    private JRadioButton bubbleRadio;
    /** Insertion sort radio button */
    private JRadioButton insertionRadio;
    /** Button group for sorting algorithms radio buttons */
    private ButtonGroup buttonGroup;
    
    private JTable table;
    private JScrollPane tableContainer;
    
    private CustomTableModel tableModel;
    
    /**
     * Initialization of whole GUI
     * @param data current iteration data array
     */
    public void initView(ArrayList<Integer> data) {
        frame = new JFrame("Sort algorithms visualisation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(10, 10));
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        startBtn = new JButton("Start");
        pauseBtn = new JButton("Pause");
        resetBtn = new JButton("Reset");
        
        topPanel.add(startBtn);
        topPanel.add(pauseBtn);
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
        
//        table = new JTable();
//        tableContainer = new JScrollPane(table);
//        contentPane.add(tableContainer, BorderLayout.PAGE_END);
//        table.getTableHeader().setReorderingAllowed(false);
//   
//        tableModel = new CustomTableModel();
//        tableModel.setColumns(data);
//        table.setModel(tableModel);
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setSize(800, 800);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    /**
     * Repaint / refresh chart
     * @param data current iteration array
     */
    public void repaint(ArrayList<Integer> data) {
        chart.updateList(data);
        frame.repaint();
    }
    
    /**
     * Add row of sorting history to table.
     * @param data current iteration array
     */
    public void addRowToTable(ArrayList<Integer> data) {
        tableModel.addRow(data);
    }

    /**
     * Asks user to input data into textfield
     * @return User's input
     */
    public String askForNumbers() {
        return JOptionPane.showInputDialog("Input numbers to sort");
    }
    
    /**
     * Creates error dialog with the message passed as parameter
     * @param errorMsg message to be printed
     */
    public void errorDialog(String errorMsg) {
        JOptionPane.showMessageDialog(null, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Getter for start button
     * @return start button
     */
    public JButton getStartBtn() {
        return startBtn;
    }
    
    /**
     * Getter for pause button
     * @return pause button
     */
    public JButton getPauseBtn() {
        return pauseBtn;
    }
    
    /**
     * Getter for reset button
     * @return reset button
     */
    public JButton getResetBtn() {
        return resetBtn;
    }
    
    /**
     * Getter for bubble sort radio button
     * @return bubble sort radio button
     */
    public JRadioButton bubbleRadioBtn() {
        return bubbleRadio;
    }
    
    /**
     * Getter for insertion sort radio button
     * @return insertion sort radio button
     */
    public JRadioButton insertionRadioBtn() {
        return insertionRadio;
    }
    
    /**
     * Getter for currently selected radio button
     * @return ActionCommand of currently selected radio button
     */
    public String getSelectedButton() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getActionCommand();
            }
        }
        return null;
    }
    
    /**
     * Disable buttons for sorting time
     */
    public void disableWhenSorting() {
        startBtn.setEnabled(false);
    }
    
    /**
     * Enable buttons after sorting
     */
    public void enableAfterSorting() {
        startBtn.setEnabled(true);
    }
}
