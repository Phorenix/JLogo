package it.unicam.cs.pa.jlogo.api.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultFileWriter implements FileWriter {

    @Override
    public void writeShapesIntoFile(Path path, String content) throws IOException {
        Files.write(path, content.getBytes());
    }
}
