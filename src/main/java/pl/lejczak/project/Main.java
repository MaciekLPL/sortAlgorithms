package pl.lejczak.project;


/**
 *
 * @author Maciek
 */

public class Main {
    
    public static void main(String[] args){
        
        BubbleSort s1 = new BubbleSort(args);
        s1.data.printCurrentState();
        s1.sort();
        System.out.println("");
        s1.data.printCurrentState();
        
        System.out.println("");
        
        
        InsertionSort s2 = new InsertionSort(args);
        s2.data.printCurrentState();
        s2.sort();
        System.out.println("");
        s2.data.printCurrentState();
    }
}
