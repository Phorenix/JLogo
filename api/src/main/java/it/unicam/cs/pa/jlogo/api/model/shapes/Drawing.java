package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;

import java.util.List;

/**
 * This interface represents a drawing in the Logo application.
 * Its function is basically the same as a collection of shapes.
 * It manages the shapes drawn in it and its background color.
 *
 * @author Luca Bianchi
 */
public interface Drawing {

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
     * This method add new line to the drawing
     *
     * @param line to add
     * @param fillingColor color of the filling of the new Figure (if it will be created)
     */
    void addNewLine(Line line, Color fillingColor);

    /**
     * This method clears the shapes in the drawing, but it doesn't clear the previous configurations
     */
    void clear();

}
