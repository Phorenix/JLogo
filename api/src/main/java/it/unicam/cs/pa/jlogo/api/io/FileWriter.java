package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * This interface has the responsibility to write into the given file the list of shapes (drawn in the drawing).
 *
 * @author Luca Bianchi
 */
public interface FileWriter {

    // TODO write header of Drawing

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
     * @param shapesList list of shapes that it does to write into the file
     * @throws IOException in case there is a problem with the given path of a file
     */
    void writeShapesIntoFile(Path path, List<Shape> shapesList) throws IOException;

    /**
     * This default method calls the other method passing the file in which it needs to write the list of shapes passed
     * as an argument
     *
     * @param file in which it needs to write the list of shapes
     * @param shapesList list of shapes it needs to write into the output file
     * @throws IOException in case there is a problem with the given path of a file
     */
    default void writeShapesIntoFile(File file, List<Shape> shapesList) throws IOException {
        writeShapesIntoFile(file.toPath(), shapesList);
    }

}
