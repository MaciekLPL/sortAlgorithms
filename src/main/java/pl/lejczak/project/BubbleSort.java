package pl.lejczak.project;

import java.util.ArrayList;

/**
 * Implements sorting algorithm - Bubble sort.
 * Needs BubbleStructure as the component.
 * @author Maciej Lejczak
 */

public class BubbleSort implements SortingFactory{
    
    /** Data structure of the algorithm */
    private BubbleStructure data;
    /** Stores algorithm iteration status */
    private int i;
    /** Stores algorithm iteration status */
    private int j;
    /**
     * Stores sort status. 
     * Initialized with False, set to True at the end of sorting.
     */
    private boolean sorted;
    /** Name of algorithm */
    private String name;
    
    /**
     * Constructor of Bubble Sort algorithm.
     * Sets all the properties needed by algorithm.
     */
    public BubbleSort(){
        this.sorted = false;
        this.i = 0;
        this.j = 0;
        this.name = "Bubble Sort";
        this.data = createStructure();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public BubbleStructure createStructure() {
        return new BubbleStructure();
    }
    
    /**
     * Bubble sort algorithm implementation.
     * After any reordering in the structure, it returns to controller.
     */
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(ArrayList<Integer> data) throws EmptyDataException {
        if (data.isEmpty())
            throw new EmptyDataException();
        this.data.setData(data);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Integer> getData() {
        return data.getData();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSorted() {
        return sorted;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }
}
