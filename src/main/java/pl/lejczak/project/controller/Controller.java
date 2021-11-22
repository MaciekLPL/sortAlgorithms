package pl.lejczak.project.controller;

import pl.lejczak.project.view.View;
import pl.lejczak.project.EmptyDataException;
import java.util.ArrayList;
import java.util.Scanner;
import pl.lejczak.project.model.AlgorithmProvider;
import pl.lejczak.project.model.SortingAlgorithm;



/**
 * Manages the work and communication between the Model and the View.
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
    
    /**
     * Constructor of controller.
     * Sets the objects that will be managed.
     * @param viewHandler view reference
     */
    public Controller(View viewHandler) {
        this.viewHandler = viewHandler;
        this.aProvider = new AlgorithmProvider();
    }
    
    /**
     * Creates and adds algorithms to local collection.
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
     * Initialization of data (numbers).
     * Creates array, validates the arguments passed to the program.
     * If the array is empty after the arguments processing, it tries to get data from user.
     * @param args arguments passed to the program
     */
    public void loadData(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        validateData(numbers, args);
        
        while (numbers.isEmpty()) {
            this.getDataFromUser(numbers);
        }
        
        this.sendData(numbers);
    }
    
    /**
     * Gets numbers separated by space from user.
     * @param numbers reference to already created, empty array
     */
    private void getDataFromUser(ArrayList<Integer> numbers) {
        
        this.viewHandler.printMessage("Enter integers separated by space: ");
        Scanner scanner = new Scanner(System.in);
        String[] input = null;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().split(" ");
        }
        
        validateData(numbers, input);
    }
    /**
     * Validates array passed as argument.
     * Checks if the element can be parsed to Integer type.
     * @param args array to validate
     * @param numbers reference to target array
     */
    private void validateData(ArrayList<Integer> numbers, String ... args) {
        
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
     * Invokes sorting algorithms.
     * Prints the state of the array after each change.
     */
    public void executeSort() {
        for (SortingAlgorithm a : algorithms) {
        
            try {
                this.viewHandler.printMessage(a.getName());
            
                while(!a.isSorted()) {
                    this.viewHandler.printCurrentState(a.getData());
                    a.sort();
                }
            
            } catch (EmptyDataException ex) {
                
                this.viewHandler.printMessage("Empty data detected. Sort stopped.");
                return;
            }            
        }
    }
}
