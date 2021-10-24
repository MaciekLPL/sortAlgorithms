/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lejczak.project;

/**
 * Custom exception.
 * Created in case an empty array appears.
 * @author Maciek
 */

class EmptyDataException extends Exception {

    /**
    * Exception constructor without parameters
    */
    public EmptyDataException() {
    }

    /**
    * Exception class constructor
    *
    * @param message message to display
    */
    public EmptyDataException(String message) {
        super(message);
    }
}

