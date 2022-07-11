package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.commands.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record DefaultFileReader(CommandParser parser) implements FileReader {

    @Override
    public List<Command> readCommandsFromFile(Path filePath) throws IOException {
        return this.parser.parse(Files.readString(filePath));
    }
}
