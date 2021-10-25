package pl.lejczak.project;

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
        
        for(int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + " | ");
        }
        
        System.out.println("");
    }
    
    /**
     * Prints message passed as parameter in the console.
     * @param message message to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
