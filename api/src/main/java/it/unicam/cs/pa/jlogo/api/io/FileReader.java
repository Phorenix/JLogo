package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.commands.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This interface just reads the commands from the file as a whole string, then passes it to a {@link CommandParser} and
 * returns the list of commands
 *
 * @author Luca Bianchi
 */
public interface FileReader {

    /**
     * Returns the parser used from the file reader
     *
     * @return the parser used from the file reader
     */
    CommandParser parser();

    /**
     * This method reads the content from the file passed as an argument and uses the parser to return a list
     * of commands read from the content
     *
     * @param filePath path of the file from which read the string containing the list of commands
     * @return the list of commands returned from the parser
     * @throws IOException In case there is a problem with the reading from the file
     * @throws InvalidNumberArgumentsException In case the parser reads an invalid number of arguments from a command
     * @throws InvalidCommandException In case the parser reads an unknown command
     */
    List<Command> readCommandsFromFile(Path filePath) throws IOException, InvalidNumberArgumentsException, InvalidCommandException;

    /**
     * This method just calls the method readCommandsFromFile() that accept a path of the file
     * passing the path of the given file as an argument
     *
     * @param file from which read the commands
     * @return the list of commands returned from the parser
     * @throws IOException In case there is a problem with the reading from the file
     * @throws InvalidNumberArgumentsException In case the parser reads an invalid number of arguments from a command
     * @throws InvalidCommandException In case the parser reads an unknown command
     */
    default List<Command> readCommandsFromFile(File file) throws IOException, InvalidNumberArgumentsException, InvalidCommandException {
        return readCommandsFromFile(file.toPath());
    }

}
