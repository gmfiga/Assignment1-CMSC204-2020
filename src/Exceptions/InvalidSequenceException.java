package Exceptions;


public class InvalidSequenceException extends RuntimeException {

    /**
     * Standard constructor
     */
    public InvalidSequenceException() {
    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public InvalidSequenceException(String message) {
        super(message);
    }
}
