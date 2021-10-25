package pl.lejczak.project;

import java.util.ArrayList;

/**
 * Structure interface, component for SortingFactory.
 * It is used to create sorting algorithm.
 * It stores data and defines the operations performed by the algorithm on the data.
 * @author Maciej Lejczak
 * @version 1.0
 */

public interface Structure {
    
    /**
     * Defines operation needed by the sorting algorithm.
     * @param i index of number to be moved
     * @param j index of target place
     */
    public void sortStep(int i, int j);
    /**
     * Getter of array size
     * @return size of array with numbers
     */
    public int getSize();
    /**
     * Getter of value from an array at given index.
     * @param i index of the value to be returned
     * @return value at given index
     */
    public int getValue(int i);
    /**
     * Setter of data structure.
     * Creates copy of given array.
     * @param data array meant to be copied
     */
    public void setData(ArrayList<Integer> data);
    /**
     * Getter of array
     * @return array
     */
    public ArrayList<Integer> getData();
}
