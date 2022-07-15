package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.commands.Command;

import java.util.List;

/**
 * This interface has the responsibility to return a list of Commands from the given String read from the file.
 *
 * @author Luca Bianchi
 *
 */
public interface CommandParser {

    /**
     * This method returns a list of commands read from the given string passed as an argument.
     *
     * @param content String from which read the commands
     * @return list of commands
     * @throws InvalidNumberArgumentsException In case the number of parameters of a command is more or less of expected
     * @throws InvalidCommandException In case the given command is unknown
     */
    List<Command> parse(String content) throws InvalidNumberArgumentsException, InvalidCommandException;

}
