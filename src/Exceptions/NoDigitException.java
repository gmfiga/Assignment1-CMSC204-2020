package Exceptions;

public class NoDigitException extends RuntimeException {

    public NoDigitException() {

    }

    public NoDigitException(String message) {
        super(message);
    }
}
