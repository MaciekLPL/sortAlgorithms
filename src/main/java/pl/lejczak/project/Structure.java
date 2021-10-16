package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public interface Structure {
    
    public void sortStep(int i, int j);
    public int getSize();
    public int getValue(int i);
    public void setData(ArrayList<Integer> data);
    public ArrayList<Integer> getData();
}
