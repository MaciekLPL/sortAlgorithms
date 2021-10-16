package pl.lejczak.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Maciek
 */

public class InsertionStructure implements Structure{
    
    private ArrayList<Integer> numbers;

    public InsertionStructure(String[] nums) {
        
        this.numbers = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++){
            
            try {
                numbers.add(Integer.parseInt(nums[i]));
            }
            catch (NumberFormatException e) {
                System.out.println("Found incorrect input. Skipping...");
            }
        }
    }
    
    public void printCurrentState() {
        
        System.out.print("| ");
        
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " | ");
        }
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
}
