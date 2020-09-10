package Exceptions;

public class UnmatchedException extends RuntimeException{

    public UnmatchedException() {
    }

    public UnmatchedException(String message) {
        super(message);
    }
}
