package Exceptions;

public class NoLowerAlphaException extends RuntimeException {
    /**
     * Standard constructor
     */
    public NoLowerAlphaException() {

    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public NoLowerAlphaException(String message) {
        super(message);
    }
}
