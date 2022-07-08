package it.unicam.cs.pa.jlogo.api.io;

import java.io.IOException;
import java.nio.file.Path;

public interface FileReader {

    String readStringFromFile(Path filePath) throws IOException;

}
