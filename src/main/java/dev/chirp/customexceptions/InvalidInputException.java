package dev.chirp.customexceptions;

public class InvalidInputException extends Exception{
    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        super("Invalid Input");
    }
}
