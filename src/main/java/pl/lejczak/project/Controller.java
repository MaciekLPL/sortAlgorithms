package pl.lejczak.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maciek
 */

public class Controller {
    
    private BubbleSort bSort;
    private InsertionSort iSort;
    private View viewHandler;
    
    public Controller(BubbleSort bSort, InsertionSort iSort, View cmdHandler) {
        
        this.iSort = iSort;
        this.bSort = bSort;
        this.viewHandler = cmdHandler;
    }
    
    public void loadData(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        validateData(args, numbers);
        
        while (numbers.isEmpty()) {
            this.getDataFromUser(numbers);
        }
        
        this.sendData(numbers);
    }
    
    private void getDataFromUser(ArrayList<Integer> numbers) {
        
        this.viewHandler.printMessage("Enter integers separated by space: ");
        Scanner scanner = new Scanner(System.in);
        String[] input = null;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().split(" ");
        }
        
        validateData(input, numbers);
    }
    
    private void validateData(String[] args, ArrayList<Integer> numbers) {
        
        for (int i = 0; i < args.length; i++){
            
            try {
                numbers.add(Integer.parseInt(args[i]));
            }
            catch (NumberFormatException e) {
                this.viewHandler.printMessage("Found invalid input. Skipping...");
            }
        }
    }
    
    private void sendData(ArrayList<Integer> data) {
        
        this.bSort.setData(data);
        this.iSort.setData(data);
    }
    
    public void sortBubble() {
        this.viewHandler.printMessage("BubbleSort");
        
        while(!this.bSort.isSorted()) {
            this.viewHandler.printCurrentState(this.bSort.getData());
            this.bSort.sort();
        }
    }
    
    public void sortInsertion() {
        this.viewHandler.printMessage("InsertionSort");
        
        while(!this.iSort.isSorted()) {
            this.viewHandler.printCurrentState(this.iSort.getData());
            this.iSort.sort();
        }
    }
}
