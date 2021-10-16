package pl.lejczak.project;

/**
 *
 * @author Maciek
 */

public class InsertionSort implements SortingFactory{
    
    public InsertionStructure data;
    
    public InsertionSort(String args[]){
        this.data = createStructure(args);
    }
    
    @Override
    public InsertionStructure createStructure(String args[]) {
        return new InsertionStructure(args);
    }
    
    @Override
    public void sort(){
        
        int size = data.getSize();

        for (int i = 1; i < size; i++) {
            int key = data.getValue(i);
            int j = i - 1;

            while (j >= 0 && key < data.getValue(j)) {
                --j;
            }

            data.sortStep(i, j + 1);
        }
    }
}
