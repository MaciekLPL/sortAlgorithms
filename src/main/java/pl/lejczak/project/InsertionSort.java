package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public class InsertionSort implements SortingFactory{
    
    private InsertionStructure data;
    private int i;
    private boolean sorted;
    private String name;
    
    public InsertionSort() {
        this.sorted = false;
        this.i = 1;
        this.name = "Insertion Sort";
        this.data = createStructure();
    }
    
    @Override
    public InsertionStructure createStructure() {
        return new InsertionStructure();
    }
    
    @Override
    public void sort(){
        
        int size = data.getSize();

        for (; i < size; i++) {
            int k = data.getValue(i);
            int j = i - 1;

            while (j >= 0 && k < data.getValue(j)) {
                data.sortStep(j, j + 1);
                --i;
                return;
            }
        }
        sorted = true;
    }
    
    @Override
    public void setData(ArrayList<Integer> data){
        this.data.setData(data);
    }
    
    @Override
    public ArrayList<Integer> getData() {
        return data.getData();
    }
    
    @Override
    public boolean isSorted() {
        return sorted;
    }
    
    public String getName() {
        return this.name;
    }
}
