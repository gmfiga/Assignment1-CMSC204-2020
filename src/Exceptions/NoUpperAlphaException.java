package Exceptions;

public class NoUpperAlphaException extends RuntimeException {
    /**
     * Standard constructor
     */
    public NoUpperAlphaException() {

    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public NoUpperAlphaException(String message) {
        super(message);
    }
}
