package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public interface SortingFactory {
    
    Structure createStructure();
    public void sort();
    public void setData(ArrayList<Integer> data);
    public ArrayList<Integer> getData();
    public boolean isSorted();
    public String getName();
}
