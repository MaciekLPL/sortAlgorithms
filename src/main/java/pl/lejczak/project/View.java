package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public class View {
    
    public void printCurrentState(ArrayList<Integer> data) {
        
        System.out.print("| ");
        
        for(int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + " | ");
        }
        
        System.out.println("");
    }
    
    public void getNumbers() {
        System.out.println("Enter integers separated by space: ");
    }
}
