package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Drawing;
import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    /*
     * Writes into the file (that has the given path) the string representation returned from the shape writer of
     * the given list of shapes, but has as the first line the string representation of the drawing
     */
    @Override
    public void writeShapesIntoFile(Path path, Drawing drawing, double width, double height) throws IOException {
        String drawingRepresentation = "SIZE " + width + " " + height + " " + drawing.getBackgroundColor().red() + " " +
                drawing.getBackgroundColor().green() + " " + drawing.getBackgroundColor().blue() + "\n";
        Files.write(path, (drawingRepresentation + this.shapeWriter.stringOf(drawing.getFigures())).getBytes());
    }

}
