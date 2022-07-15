package it.unicam.cs.pa.jlogo.api.io;

/**
 * Custom exception in case when the parser is doing the parsing of the command, but finds out that a command has more
 * or less arguments than needed.
 * The error message is the needed number of parameters
 *
 * @author Luca Bianchi
 *
 */
public class InvalidNumberArgumentsException extends Exception {
    public InvalidNumberArgumentsException(String numArguments) {
        super("Number of arguments should be: " + numArguments);
    }

    public InvalidNumberArgumentsException() {
        super("Invalid number of arguments for the command passed");
    }
}
