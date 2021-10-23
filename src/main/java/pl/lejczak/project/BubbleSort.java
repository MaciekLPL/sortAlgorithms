package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public class BubbleSort implements SortingFactory{
    
    private BubbleStructure data;
    private int i;
    private int j;
    private boolean sorted;
    private String name;
    
    public BubbleSort(){
        this.sorted = false;
        this.i = 0;
        this.j = 0;
        this.name = "Bubble Sort";
        this.data = createStructure();
    }
    
    @Override
    public BubbleStructure createStructure() {
        return new BubbleStructure();
    }
    
    @Override
    public void sort(){
        
        int size = data.getSize();
        
        for (; i < size - 1; i++) {
            if (j >= size - i - 1) j = 0;
            for (; j < size - i - 1; j++) {
                if (data.getValue(j) > data.getValue(j + 1)) {
                    data.sortStep(j, j + 1);
                    j++;
                    return;
                }
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
