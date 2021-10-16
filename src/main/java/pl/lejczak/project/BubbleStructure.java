package pl.lejczak.project;

import java.util.ArrayList; 
import java.util.Collections;
/**
 *
 * @author Maciek
 */

public class BubbleStructure implements Structure{
    
    private ArrayList<Integer> numbers;
    
    public BubbleStructure(){
        this.numbers = new ArrayList<Integer>();
    }
    
    @Override
    public void sortStep(int i, int j) {
        Collections.swap(numbers, i, j);
    }
    
    @Override
    public int getSize() {
        return numbers.size();
    }
    
    @Override
    public int getValue(int i){
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
