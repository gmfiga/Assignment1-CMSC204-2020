package Exceptions;

public class UnmatchedException extends RuntimeException {
    /**
     * Standard constructor
     */
    public UnmatchedException() {
        super("Passwords do not match");
    }

    /**
     * constructor
     *
     * @param message the exception message
     */
    public UnmatchedException(String message) {
        super("Passwords do not match");
    }
}
