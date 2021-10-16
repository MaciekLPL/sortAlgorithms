package pl.lejczak.project;

import java.util.ArrayList;

/**
 *
 * @author Maciek
 */

public class InsertionStructure implements Structure{
    
    private ArrayList<Integer> numbers;
    
    public InsertionStructure(){
        this.numbers = new ArrayList<Integer>();
    }
    
    @Override
    public void sortStep(int i, int j) {
        int tmp = numbers.get(i);
        numbers.remove(i);
        numbers.add(j, tmp);
    }
    
    @Override
    public int getSize() {
        return numbers.size();
    }
    
    @Override
    public int getValue(int i) {
        return numbers.get(i);
    }
    
    @Override
    public void setData(ArrayList<Integer> data) {
        numbers = new ArrayList<Integer>(data);
    }
    
    @Override
    public ArrayList<Integer> getData() {
        return numbers;
    }
}
