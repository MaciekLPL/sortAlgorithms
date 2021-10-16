package pl.lejczak.project;

/**
 *
 * @author Maciek
 */

public class BubbleSort implements SortingFactory{
    
    public BubbleStructure data;
    
    public BubbleSort(String args[]){
        this.data = createStructure(args);
    }
    
    @Override
    public BubbleStructure createStructure(String args[]) {
        return new BubbleStructure(args);
    }
    
    @Override
    public void sort(){
        
        int size = data.getSize();
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {

                if (data.getValue(j) > data.getValue(j + 1)) {
                    data.sortStep(j, j + 1);
                }
            }
        }
    }
}
