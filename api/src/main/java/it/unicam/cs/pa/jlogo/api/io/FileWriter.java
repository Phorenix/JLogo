package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Drawing;
import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This interface has the responsibility to write into the given file the list of shapes (drawn in the drawing) and
 * the string representation for a drawing.
 *
 * @author Luca Bianchi
 */
public interface FileWriter {

    /**
     * Returns the shape writer used to write a shape (or a list of shapes)
     *
     * @return the shape writer used to write a shape (or a list of shapes)
     */
    ShapeWriter shapeWriter();

    /**
     * Writes the string returned from the ShapeWriter into the file that has the given path
     *
     * @param path of the file in which it needs to write
     * @param drawing drawing containing the list of shapes that it needs to write into the file
     * @param width width of the drawing
     * @param height height of the drawing
     * @throws IOException in case there is a problem with the given path of a file
     */
    void writeShapesIntoFile(Path path, Drawing drawing, double width, double height) throws IOException;

    /**
     * This default method calls the method writeShapesIntoFile() that takes the path of file
     * passing the file in which it needs to write the list of shapes passed as an argument
     *
     * @param file in which it needs to write the list of shapes
     * @param drawing drawing containing the list of shapes it needs to write into the output file
     * @param width width of the drawing
     * @param height height of the drawing
     * @throws IOException in case there is a problem with the given path of a file
     */
    default void writeShapesIntoFile(File file, Drawing drawing, double width, double height) throws IOException {
        writeShapesIntoFile(file.toPath(), drawing, width, height);
    }

}
