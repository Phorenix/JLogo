package it.unicam.cs.pa.jlogo.console;

import it.unicam.cs.pa.jlogo.api.Controller;
import it.unicam.cs.pa.jlogo.api.LogoController;
import it.unicam.cs.pa.jlogo.api.io.InvalidCommandException;
import it.unicam.cs.pa.jlogo.api.io.InvalidNumberArgumentsException;

import java.io.File;
import java.io.IOException;

/**
 * This simple class is just used to execute the commands in the given file, printing the output on output file, using
 * the {@link Controller} of the api module (meanwhile it also prints the instructions operated on the drawing)
 *
 * @author Luca Bianchi
 */
public class ExecuteUtils {

    public static void execute(File inputFile, File outputFile, double width, double height) throws InvalidCommandException, IOException, InvalidNumberArgumentsException {

        Controller controller = new LogoController(new ConsoleDrawing(), width, height);

        controller.readCommandsFromFile(inputFile);

        controller.executeAllCommands();

        controller.writeShapesIntoFile(outputFile);

    }
}
