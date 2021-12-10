package pl.lejczak.project;

import pl.lejczak.project.view.View;
import pl.lejczak.project.controller.Controller;

/**
 * Main class, contains main function.
 * @author Maciej Lejczak
 * @version 1.0
 */

public class Main {
    /**
     * Main function.
     * Creates objects, calls controller.
     * As parameters accepts only integers, which are meant to be sorted.
     * @param args integers separated by space
     */
    public static void main(String[] args){
        
        View v = new View();
        Controller c = new Controller(v);
        
        c.addAlgorithm("BubbleSort");
        c.addAlgorithm("InsertionSort");
        
        if (c.loadData(args)){
            c.initController();
        }
    }
}
