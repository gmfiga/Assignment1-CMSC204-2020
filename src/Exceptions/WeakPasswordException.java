package Exceptions;

public class WeakPasswordException extends RuntimeException {
    /**
     * Standard constructor
     */
    public WeakPasswordException() {
    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public WeakPasswordException(String message) {
        super(message);
    }
}
