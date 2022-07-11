package it.unicam.cs.pa.jlogo.api.io;

import java.io.IOException;
import java.nio.file.Path;

public interface FileWriter {

    void writeShapesIntoFile(Path path, String content) throws IOException;

}
