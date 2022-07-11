package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.commands.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileReader {

    CommandParser parser();

    List<Command> readCommandsFromFile(Path filePath) throws IOException;

    default List<Command> readCommandsFromFile(File file) throws IOException {
        return readCommandsFromFile(file.toPath());
    }

}
