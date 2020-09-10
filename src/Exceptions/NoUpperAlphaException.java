package Exceptions;

public class NoUpperAlphaException extends RuntimeException{

    public NoUpperAlphaException() {

    }

    public NoUpperAlphaException(String message) {
        super(message);
    }
}
