package pl.lejczak.project.model;

import java.util.ArrayList;
import pl.lejczak.project.EmptyDataException;

/**
 * Creates products, which are sorting algorithms.
 * Needs sorting structure as the component.
 * @author Maciej Lejczak
 * @version 1.0
 */

public interface SortingAlgorithm {
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
     */
    public void setData(ArrayList<Integer> data);
    /**
     * Getter of array.
     * @return array
     * @throws EmptyDataException Thrown when blank data detected.
     */
    public ArrayList<Integer> getData() throws EmptyDataException;
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
    
    /**
     * Resets algorithm and its data.
     */
    public void reset();
}
