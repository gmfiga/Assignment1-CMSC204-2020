package Exceptions;

public class NoLowerAlphaException extends RuntimeException{

    public NoLowerAlphaException() {

    }

    public NoLowerAlphaException(String message) {
        super(message);
    }
}
