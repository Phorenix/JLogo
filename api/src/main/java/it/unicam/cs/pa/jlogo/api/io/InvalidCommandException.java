package it.unicam.cs.pa.jlogo.api.io;

/**
 * Custom exception in case the command passed to the parser is unknown.
 *
 * @author Luca Bianchi
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String errorMessage) {
        super("Invalid command passed: " + errorMessage);
    }

    public InvalidCommandException() {
        super("Invalid command passed");
    }

}
