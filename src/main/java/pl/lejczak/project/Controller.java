package pl.lejczak.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the work and communication between the Model and the View.
 * @author Maciej Lejczak
 */
public class Controller {
    /** Stores Bubble sort algorithm - Model */
    private BubbleSort bSort;
    /** Stores Insertion sort algorithm - Model */
    private InsertionSort iSort;
    /** Stores View */
    private View viewHandler;
    
    /**
     * Constructor of controller.
     * Sets the objects that will be managed.
     * @param bSort Bubble sort algorithm reference
     * @param iSort Insertion sort algorithm reference
     * @param cmdHandler view reference
     */
    public Controller(BubbleSort bSort, InsertionSort iSort, View cmdHandler) {
        
        this.iSort = iSort;
        this.bSort = bSort;
        this.viewHandler = cmdHandler;
    }
    
    /**
     * Initialization of data (numbers).
     * Creates array, validates the arguments passed to the program.
     * If the array is empty after the arguments processing, it tries to get data from user.
     * @param args arguments passed to the program
     */
    public void loadData(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        validateData(args, numbers);
        
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
        
        validateData(input, numbers);
    }
    /**
     * Validates array passed as argument.
     * Checks if the element can be parsed to Integer type.
     * @param args array to validate
     * @param numbers reference to target array
     */
    private void validateData(String[] args, ArrayList<Integer> numbers) {
        
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
        try {
            this.bSort.setData(data);
            this.iSort.setData(data);
        } catch (EmptyDataException ex) {
            this.viewHandler.printMessage("Empty data passed to model");
        }
    }
    
    /**
     * Invokes sorting algorithms.
     * Prints the state of the array after each change.
     * @param sortAlgorithm sorting algorithm to be invoked
     */
    public void executeSort(SortingFactory sortAlgorithm) {
        this.viewHandler.printMessage(sortAlgorithm.getName());
        
        while(!sortAlgorithm.isSorted()) {
            this.viewHandler.printCurrentState(sortAlgorithm.getData());
            sortAlgorithm.sort();
        }
    }
}
