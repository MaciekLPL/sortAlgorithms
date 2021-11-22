package pl.lejczak.project.model;

import java.util.ArrayList;

/**
 * Insertion sort structure implements number insertion into the given position.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class InsertionStructure implements Structure{
    
    /** Stores numbers meant to be sorted */
    private ArrayList<Integer> numbers;
    
    /**
     * Defines operation needed by the sorting algorithm.
     * Insertion sort structure uses insertion operation to change order of the elements.
     * @param i index of number to be moved
     * @param j index of target place
     */
    @Override
    public void sortStep(int i, int j) {
        int tmp = numbers.get(i);
        numbers.remove(i);
        numbers.add(j, tmp);
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
    public int getValue(int i) {
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
