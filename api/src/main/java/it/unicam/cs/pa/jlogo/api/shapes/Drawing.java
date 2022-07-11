package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;

import java.util.List;

/**
 * This interface represents a drawing in the Logo application.
 * Its function is basically the same as a collection of shapes.
 * It manages the shapes drawn in it and its background color.
 */
public interface Drawing {

    // TODO returns Color?

    /**
     * Returns the background color
     * @return the background color
     */
    Color getBackgroundColor();

    /**
     * Set the background color with the given color
     *
     * @param color how to change the background color
     */
    void setBackgroundColor(Color color);

    /**
     * Returns all the shapes in the drawing
     *
     * @return all the shapes in the drawing
     */
    List<Shape> getFigures();

    /**
     * This method add new shape to the drawing
     *
     * @param shape to add
     */
    void addNewShape(Shape shape);

    /**
     *
     * @param line
     */
    void removeShape(Line line);

    /**
     * This method clears the shapes in the drawing, but it doesn't clear the previous configurations
     */
    void clear();

}
