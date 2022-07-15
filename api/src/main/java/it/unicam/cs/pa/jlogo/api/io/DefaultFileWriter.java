package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Simple implementation of a {@link FileWriter}
 *
 * @author Luca Bianchi
 *
 * @param shapeWriter the shape writer used to return the string representation of a shape
 */
public record DefaultFileWriter(ShapeWriter shapeWriter) implements FileWriter {

    @Override
    public void writeShapesIntoFile(Path path, List<Shape> shapesList) throws IOException {
        // Writes into the file (that has the given path) the string representation returned from the shape writer of
        // the given list of shapes
        Files.write(path, this.shapeWriter.stringOf(shapesList).getBytes());
    }
}
