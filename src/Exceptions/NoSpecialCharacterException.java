package Exceptions;

public class NoSpecialCharacterException extends RuntimeException{

    public NoSpecialCharacterException() {
    }

    public NoSpecialCharacterException(String message) {
        super(message);
    }
}
