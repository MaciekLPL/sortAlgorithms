package pl.lejczak.project.model;

import java.util.ArrayList;
import pl.lejczak.project.EmptyDataException;

/**
 * Implements sorting algorithm - Insertion sort.
 * Needs InsertionStructure as the component.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class InsertionSort implements SortingAlgorithm{
    /** Data structure of the algorithm */
    private final InsertionStructure data;
    /** Stores algorithm iteration status */
    private int i;
    /**
     * Stores sort status. 
     * Initialized with False, set to True at the end of sorting.
     */
    private boolean sorted;
    /** Name of algorithm */
    private final String name;
    
    /**
     * Constructor of Insertion Sort algorithm.
     * Sets all the properties needed by algorithm.
     */
    public InsertionSort() {
        this.sorted = false;
        this.i = 1;
        this.name = "Insertion Sort";
        this.data = createStructure();
    }
    
    /** 
     * {@inheritDoc}
     */
    @Override
    public InsertionStructure createStructure() {
        return new InsertionStructure();
    }
    
    /**
     * Insertion sort algorithm implementation.
     * After any reordering in the structure, it returns to controller.
     */
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(ArrayList<Integer> data) {
        this.data.setData(data);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Integer> getData() throws EmptyDataException {
        if (data.getSize() == 0)
            throw new EmptyDataException();
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
