package it.unicam.cs.pa.jlogo.api.io;

/**
 * Custom exception in case when the parser is doing the parsing of the command, but finds out that a command has more
 * or less arguments than needed.
 */
public class InvalidNumberArgumentsException extends Exception {
    public InvalidNumberArgumentsException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidNumberArgumentsException() {
        super();
    }
}
