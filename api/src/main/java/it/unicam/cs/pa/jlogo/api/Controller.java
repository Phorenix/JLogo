package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.io.InvalidCommandException;
import it.unicam.cs.pa.jlogo.api.io.InvalidNumberArgumentsException;

import java.io.File;
import java.io.IOException;

/**
 * This interface is the controller used to control the activities in the Logo Application, making it so
 * another module can interact with the model using the controller.
 *
 * @author Luca Bianchi
 */
public interface Controller {

    /**
     * This method reads the instructions written in the given file, transforming them into a list of commands
     *
     * @param file file from which read the list of commands
     * @throws IOException in case the read from file returns an exception
     * @throws InvalidNumberArgumentsException in case the number of arguments of a new command isn't the same as expected
     * @throws InvalidCommandException in case the given command doesn't exist
     */
    void readCommandsFromFile(File file) throws IOException, InvalidNumberArgumentsException, InvalidCommandException;

    /**
     * This method writes the string representation of the drawing into the given file
     *
     * @param file file in which will be written the shapes of the drawing (if it doesn't exist it will be created)
     * @throws IOException in case the file that will be written reports an error
     */
    void writeShapesIntoFile(File file) throws IOException;

    /**
     * This method execute the next command on the list of commands (but only if there are commands on the list)
     */
    void executeNextCommand();

    /**
     * This method executes all the commands (or remaining commands) in the list
     */
    void executeAllCommands();

    /**
     * This method will clear the controller, but only clearing the drawing and resetting the list of commands.
     * (It can usually be used from a "clear" command in the GUI)
     */
    void clear();

}
