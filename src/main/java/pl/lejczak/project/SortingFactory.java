package pl.lejczak.project;

/**
 *
 * @author Maciek
 */

public interface SortingFactory {
    
    Structure createStructure(String args[]);
    public void sort();
    
}
