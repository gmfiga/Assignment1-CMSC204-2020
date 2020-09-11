package Exceptions;

public class LengthException extends RuntimeException {

    /**
     * Standard constructor
     */
    public LengthException() {
    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public LengthException(String message) {
        super(message);
    }
}
