package pl.lejczak.project;

import java.util.ArrayList;

/**
 * Creates products, which are sorting algorithms.
 * Needs sorting structure as the component.
 * @author Maciej Lejczak
 */

public interface SortingFactory {
    /**
     * Data structure component creator.
     * Creates the appropriate data structure for the sorting algorithm.
     * @return structure to be used in the sorting algorithm.
     */
    Structure createStructure();
    /**
     * Sorting algorithm implementation.
     * After any reordering in the structure, it returns to controller.
     */
    public void sort();
    /**
     * Setter of data structure.
     * @param data array to be transferred to data structure
     * @throws EmptyDataException Thrown when data passed as parameter is empty
     */
    public void setData(ArrayList<Integer> data) throws EmptyDataException;
    /**
     * Getter of array.
     * @return array
     */
    public ArrayList<Integer> getData();
    /**
     * Getter of information about sorting status.
     * @return information whether the sorting algorithm has completed all iterations
     */
    public boolean isSorted();
    /**
     * Getter of algorithm name.
     * @return name of algorithm
     */
    public String getName();
}
