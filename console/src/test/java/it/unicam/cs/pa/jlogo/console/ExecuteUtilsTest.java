package it.unicam.cs.pa.jlogo.console;

import it.unicam.cs.pa.jlogo.api.io.InvalidCommandException;
import it.unicam.cs.pa.jlogo.api.io.InvalidNumberArgumentsException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to check the usage of the class {@link ExecuteUtils}
 *
 * @author Luca Bianchi
 */

public class ExecuteUtilsTest {

    @Test
    public void shouldExecuteCommandsTestFile() throws InvalidCommandException, IOException, InvalidNumberArgumentsException {
        File inputFile = new File("src/test/resources/commandsFile.txt");
        if (!inputFile.isFile() || !inputFile.exists()) {
            System.err.println("Invalid input file passed");
            return;
        }
        File outputFile = new File("src/test/resources/outputTestFile.logo");
        ExecuteUtils.execute(inputFile, outputFile, 500, 500);
        assertTrue(outputFile.isFile());
    }

}
