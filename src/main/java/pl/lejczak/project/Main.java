package pl.lejczak.project;

/**
 * Main class, contains main function.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class Main {
    /**
     * Main function.
     * Creates objects, calls controller.
     * As parameters accepts only integers, which are meant to be sorted.
     * @param args integers separated by space
     */
    public static void main(String[] args){
        
        BubbleSort bs = new BubbleSort();
        InsertionSort is = new InsertionSort(); 
        View v = new View();
        Controller c = new Controller(bs, is, v);
        
        c.loadData(args);
        c.executeSort(bs);
        c.executeSort(is);
       
    }
}
