package pl.lejczak.project;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public String[] getNumbers() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integers separated by space: ");
        String[] input = null;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().split(" ");
        }
        return input;
    }
    
}
