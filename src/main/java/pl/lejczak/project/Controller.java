package pl.lejczak.project;

import java.util.ArrayList;

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
        
        for (int i = 0; i < args.length; i++){
            
            try {
                numbers.add(Integer.parseInt(args[i]));
            }
            catch (NumberFormatException e) {
                System.out.println("Found incorrect input. Skipping...");
            }
        }
        
        if (numbers.size() == 0) {
            this.getDataFromUser();
        }
        
        this.sendData(numbers);
    }
    
    private void sendData(ArrayList<Integer> data) {
        
        this.bSort.setData(data);
        this.iSort.setData(data);
    }
    
    public void sortBubble() {
        System.out.println("BubbleSort");
        
        while(!this.bSort.isSorted()) {
            this.viewHandler.printCurrentState(this.bSort.getData());
            this.bSort.sort();
        }
    }
    
    public void sortInsertion() {
        System.out.println("InsertionSort");
        
        while(!this.iSort.isSorted()) {
            this.viewHandler.printCurrentState(this.iSort.getData());
            this.iSort.sort();
        }
    }
    
    public void getDataFromUser() {
        
        
    }
    
}
