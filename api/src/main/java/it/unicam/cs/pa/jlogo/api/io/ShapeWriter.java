package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This interface is used to return the representation as a string of a given shape (or shapes).
 *
 * @author Luca Bianchi
 */
public interface ShapeWriter {

    /**
     * Returns the string representation of the given {@link Shape}
     *
     * @param shape shape of which is needed the string representation
     * @return the string representation of the given shape
     */
    String stringOf(Shape shape);

    /**
     * This default method takes a list of shapes, but then calls the other method to get the representation for each
     * of the given shapes and lastly returns it as a whole string of all the shapes
     *
     * @param shapesList list of shapes of which is needed the string representation
     * @return the string containing the string representation of all the shapes
     */
    default String stringOf(List<Shape> shapesList) {
        return shapesList.stream().map(this::stringOf).collect(Collectors.joining("\n"));
    }

}
