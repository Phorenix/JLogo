package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.commands.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Simple implementation of a {@link FileReader}.
 *
 * @author Luca Bianchi
 *
 * @param parser the Parser used to parse the commands from the string read from the given file
 *
 */
public record DefaultFileReader(CommandParser parser) implements FileReader {

    @Override
    public List<Command> readCommandsFromFile(Path filePath) throws IOException, InvalidNumberArgumentsException, InvalidCommandException {
        return this.parser.parse(Files.readString(filePath));
    }
}
