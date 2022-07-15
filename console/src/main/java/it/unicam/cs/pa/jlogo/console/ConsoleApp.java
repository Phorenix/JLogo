package it.unicam.cs.pa.jlogo.console;

import it.unicam.cs.pa.jlogo.api.LogoController;
import it.unicam.cs.pa.jlogo.api.io.InvalidCommandException;
import it.unicam.cs.pa.jlogo.api.io.InvalidNumberArgumentsException;

import java.io.File;
import java.io.IOException;

public class ConsoleApp {

    public static void main(String[] args) throws IOException, InvalidNumberArgumentsException, InvalidCommandException {
        if (args.length != 4) {
            System.err.println("Invalid number of arguments. Needed inputFile, outputFile, x and y of the drawing");
            return;
        }

        LogoController controller;

        try {
            controller = LogoController.getLogoController(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        } catch (NumberFormatException e) {
            System.err.println("Invalid dimensions. X and Y must be numbers.");
            return;
        }

        File inputFile = new File(args[0]);
        if (!inputFile.isFile() || !inputFile.exists())
            System.err.println("Invalid input file passed");

        File outputFile = new File(args[1]);
        if (!outputFile.isFile())
            System.err.println("Invalid output file passed");

        controller.readCommandsFromFile(inputFile);

        controller.executeAllCommands();

        controller.writeShapesIntoFile(outputFile);

    }

}
