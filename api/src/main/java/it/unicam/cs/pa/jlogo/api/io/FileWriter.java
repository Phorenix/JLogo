package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.shapes.Shape;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileWriter {

    ShapeWriter shapeWriter();

    void writeShapesIntoFile(Path path, List<Shape> shapesList) throws IOException;

    default void writeShapesIntoFile(File file, List<Shape> shapesList) throws IOException {
        writeShapesIntoFile(file.toPath(), shapesList);
    }

}
