package pl.lejczak.project;

import java.util.ArrayList; 
import java.util.Collections;

/**
 * Bubble sort structure implements place swapping function.
 * @author Maciej Lejczak
 */

public class BubbleStructure implements Structure{
    
    /** Stores numbers meant to be sorted */
    private ArrayList<Integer> numbers;
    
    /**
     * Defines operation needed by the sorting algorithm.
     * Bubble sort structure uses swap operation to change order of the elements.
     * @param i index of number to be moved
     * @param j index of target place
     */
    @Override
    public void sortStep(int i, int j) {
        Collections.swap(numbers, i, j);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return numbers.size();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getValue(int i){
        return numbers.get(i);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(ArrayList<Integer> data) {
        numbers = new ArrayList<>(data);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Integer> getData() {
        return numbers;
    }
}
