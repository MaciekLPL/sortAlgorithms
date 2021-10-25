package pl.lejczak.project;

/**
 * Custom exception.
 * Created in case an empty array appears.
 * @author Maciek
 * @version 1.0
 */

public class EmptyDataException extends Exception {

    /**
    * Exception constructor without parameters
    */
    public EmptyDataException() {
    }

    /**
    * Exception class constructor
    * @param message message to display
    */
    public EmptyDataException(String message) {
        super(message);
    }
}

