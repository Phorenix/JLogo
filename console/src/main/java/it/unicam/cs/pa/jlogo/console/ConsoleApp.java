package it.unicam.cs.pa.jlogo.console;

import it.unicam.cs.pa.jlogo.api.io.InvalidCommandException;
import it.unicam.cs.pa.jlogo.api.io.InvalidNumberArgumentsException;

import java.io.File;
import java.io.IOException;

/**
 * Class with main that executes the logo application from console.
 * It must have 4 arguments, which are respectively: input file, output file, width of the drawing and height of the drawing
 *
 * @author Luca Bianchi
 */
public class ConsoleApp {

    public static void main(String[] args) throws IOException, InvalidNumberArgumentsException, InvalidCommandException {
        if (args.length != 4) {
            System.err.println("Invalid number of arguments. Needed: inputFile, outputFile, x and y of the drawing");
            return;
        }

        double width = 0;
        double height = 0;

        try {
            width = Double.parseDouble(args[2]);
            height = Double.parseDouble(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("Invalid dimensions. X and Y must be numbers.");
            return;
        }

        File inputFile = new File(args[0]);
        if (!inputFile.isFile() || !inputFile.exists()) {
            System.err.println("Invalid input file passed");
            return;
        }

        File outputFile = new File(args[1]);

        ExecuteUtils.execute(inputFile, outputFile, width, height);

    }
}
