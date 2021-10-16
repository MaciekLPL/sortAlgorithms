package pl.lejczak.project;


/**
 *
 * @author Maciek
 */

public class Main {
    
    public static void main(String[] args){
        
        BubbleSort bs = new BubbleSort();

        InsertionSort is = new InsertionSort();
        
        View v = new View();
        
        Controller c = new Controller(bs, is, v);
        
        c.loadData(args);
        c.sortBubble();
        c.sortInsertion();
    }
}
