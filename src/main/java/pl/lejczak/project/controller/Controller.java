package pl.lejczak.project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.lejczak.project.view.View;
import pl.lejczak.project.EmptyDataException;
import java.util.ArrayList;
import javax.swing.Timer;
import pl.lejczak.project.model.AlgorithmProvider;
import pl.lejczak.project.model.SortingAlgorithm;

/**
 * Manages the work and communication between the Model and the View.
 *
 * @author Maciej Lejczak
 * @version 1.0
 */
public class Controller {

    /** Stores algorithms - Model */
    private final ArrayList<SortingAlgorithm> algorithms = new ArrayList<>();
    /** Stores algorithm creator - Model */
    private final AlgorithmProvider aProvider;
    /** Stores View */
    private final View viewHandler;
    /** Stores original user input */
    private final ArrayList<Integer> orgNumbers;
    /** Swing timer for algorithm visualization */
    private Timer timer = null;

    /**
     * Constructor of controller. Sets the objects that will be managed.
     *
     * @param viewHandler view reference
     */
    public Controller(View viewHandler) {
        this.viewHandler = viewHandler;
        this.aProvider = new AlgorithmProvider();
        orgNumbers = new ArrayList<>();
    }

    /**
     * Initialization of action listeners
     */
    public void initController() {
        viewHandler.getStartBtn().addActionListener(e -> {
            executeSort();
            timer.start();
        });

        viewHandler.getResetBtn().addActionListener(e -> resetSorting());
        
        viewHandler.bubbleRadioBtn().addActionListener(e -> display());
        viewHandler.insertionRadioBtn().addActionListener(e -> display());
    }

    /**
     * Resets currently displayed algorithm according to radio button selection
     */
    public void resetSorting() {
        SortingAlgorithm a = selectAlgorithm();
        if (a == null) {
            return;
        }
        
        a.reset();
        a.setData(orgNumbers);
        
        try {
            viewHandler.repaint(a.getData());
        } catch (EmptyDataException ex) {
            viewHandler.printMessage("Empty data detected. Sort stopped.");
        }
    }
    
    /**
     * Change currently displayed algorithm according to radio button selection change
     */
    public void display() {
        
        SortingAlgorithm a = selectAlgorithm();
        if (a == null) {
            return;
        }
        
        try {
            viewHandler.repaint(a.getData());
        } catch (EmptyDataException ex) {
            viewHandler.printMessage("Empty data detected. Sort stopped.");
        }
        
    }

    /**
     * Creates and adds algorithms to local collection.
     *
     * @param name name of algorithm to be created
     */
    public void addAlgorithm(String name) {

        SortingAlgorithm createdAlgorithm = aProvider.createAlgorithm(name);

        if (createdAlgorithm != null) {
            this.algorithms.add(createdAlgorithm);
        } else {
            viewHandler.printMessage("Could not created algorithm with given name");
        }
    }

    /**
     * Initialization of data (numbers). Creates array, validates the arguments
     * passed to the program. If the array is empty after the arguments
     * processing, it tries to get data from user.
     *
     * @param args arguments passed to the program
     * @return Retry or cancel
     */
    public boolean loadData(String[] args) {

        validateData(orgNumbers, args);

        while (orgNumbers.isEmpty()) {

            boolean ask = this.getDataFromUser(orgNumbers);
            if (!ask) {
                return false;
            }
        }

        this.sendData(orgNumbers);
        viewHandler.initView(orgNumbers);
        return true;
    }

    /**
     * Gets numbers separated by space from user.
     *
     * @param numbers reference to already created, empty array
     * @return Retry or cancel
     */
    private boolean getDataFromUser(ArrayList<Integer> numbers) {

        String input = this.viewHandler.askForNumbers();
        if (input == null) {
            return false;
        }
        String[] inputArray = input.split(" ");
        validateData(numbers, inputArray);

        return true;
    }

    /**
     * Validates array passed as argument. Checks if the element can be parsed
     * to Integer type.
     *
     * @param args array to validate
     * @param numbers reference to target array
     */
    private void validateData(ArrayList<Integer> numbers, String... args) {

        for (String arg : args) {
            try {
                numbers.add(Integer.parseInt(arg));
            } catch (NumberFormatException e) {
                this.viewHandler.printMessage("Found invalid input. Skipping...");
            }
        }
    }

    /**
     * Sends data to model.
     * @param data array with numbers to be sorted
     */
    private void sendData(ArrayList<Integer> data) {
        algorithms.forEach((SortingAlgorithm a) -> a.setData(data));
    }

    /**
     * Invokes sorting algorithms. Prints the state of the array after each change.
     */
    public void executeSort() {
        
        SortingAlgorithm a = selectAlgorithm();
        if (a == null) {
            return;
        }

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (a.isSorted()) {
                    ((Timer) e.getSource()).stop();
                    viewHandler.enableAfterSorting();
                } else {
                    a.sort();
                    viewHandler.disableWhenSorting();
                }
                
                try {
                    viewHandler.repaint(a.getData());
                } catch (EmptyDataException ex) {
                    viewHandler.printMessage("Empty data detected. Sort stopped.");
                }
            }
        });
    }

    
    /**
     * Function selects proper algorithm according to selected radio button
     * @return proper algorithm or null.
     */
    public SortingAlgorithm selectAlgorithm() {
        String button = viewHandler.getSelectedButton();

        for (SortingAlgorithm a : algorithms) {
            if (a.getName().equals(button)) {
                return a;
            }
        }
        return null;
    }
}
