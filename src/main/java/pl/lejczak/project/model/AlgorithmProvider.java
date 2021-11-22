package pl.lejczak.project.model;

/**
 * Used to create objects of SortingAlgorithm type.
 * @author Maciej Lejczak
 * @version 1.0
 */
public class AlgorithmProvider {
    
    /**
     * Creates algorithm based on given name     
     * @param name Name of the alorithm.
     * @return Created algorithm or null if given name is invalid.
     */
    public SortingAlgorithm createAlgorithm(String name) {
        
        if ("BubbleSort".equalsIgnoreCase(name))
            return new BubbleSort();
        
        else if ("InsertionSort".equalsIgnoreCase(name))
            return new InsertionSort();
        
        else
            return null;
    }
}
