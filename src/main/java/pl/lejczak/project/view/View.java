package pl.lejczak.project.view;

import java.util.ArrayList;

/**
 * Used to print informations in console.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class View {
    
    /**
     * Prints current state of array of numbers.
     * @param data array with numbers
     */
    public void printCurrentState(ArrayList<Integer> data) {
        
        System.out.print("| ");
        
        data.stream().map(str -> str + " | ").forEach(System.out::print);
        
        System.out.println();
    }
    
    /**
     * Prints message passed as parameter in the console.
     * @param message message to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
