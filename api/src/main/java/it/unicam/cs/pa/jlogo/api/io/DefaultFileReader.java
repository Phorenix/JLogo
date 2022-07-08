package it.unicam.cs.pa.jlogo.api.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultFileReader implements FileReader {

    @Override
    public String readStringFromFile(Path filePath) throws IOException {
        return Files.readString(filePath);
    }
}
