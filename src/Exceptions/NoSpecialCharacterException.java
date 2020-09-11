package Exceptions;

public class NoSpecialCharacterException extends RuntimeException {
    /**
     * Standard constructor
     */
    public NoSpecialCharacterException() {
    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public NoSpecialCharacterException(String message) {
        super(message);
    }
}
