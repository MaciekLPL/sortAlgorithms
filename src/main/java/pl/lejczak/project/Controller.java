package pl.lejczak.project;

public class Controller {
    
    private BubbleSort bSort;
    private InsertionSort iSort;
    private View cmdHandler;
    
    public Controller(BubbleSort bSort, InsertionSort iSort, View cmdHandler) {
        
        this.iSort = iSort;
        this.bSort = bSort;
        this.cmdHandler = cmdHandler;
        
    }
    
    
    
    
    
}
