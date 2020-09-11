package Exceptions;

public class NoDigitException extends RuntimeException {

    /**
     * Standard constructor
     */
    public NoDigitException() {

    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public NoDigitException(String message) {
        super(message);
    }
}
