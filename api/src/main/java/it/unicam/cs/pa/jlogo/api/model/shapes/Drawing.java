package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;

import java.util.List;

/**
 * This interface represents a drawing in the Logo application.
 * Its function is basically the same as a collection of shapes.
 * It manages the shapes drawn in it and its background color.
 * It also has the responsibility to check whether the added line form a new figure or not.
 *
 * @author Luca Bianchi
 */
public interface Drawing {

    /**
     * Returns the background color
     *
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
     * This method add new line to the drawing. It should also check if the added line creates a new figure or not.
     *
     * @param line to add
     * @param fillingColor color of the filling of the new Figure (if it will be created)
     */
    void addNewLine(Line line, Color fillingColor);

    /**
     * This method clears the shapes in the drawing, but it doesn't clear the previous configurations
     */
    void clear();

    /**
     * This method should be called when a new Line is added to the drawing.
     * A class implementing this interface can override this method to make it so it returns the log of the new added line
     * (The default implementation does nothing)
     *
     * @param line line added to print
     */
    default void onAddNewLine(Line line) {

    }

    /**
     * This method should be called when a new polygon is added to the drawing.
     * A class implementing this interface can override this method to make it so it returns the log of the new added polygon
     * (The default implementation does nothing)
     *
     * @param figure polygon added to print
     */
    default void onAddNewPolygon(Figure figure) {

    }

    /**
     * This method should be called when a line is removed from the drawing, because added to a new added figure.
     * (The default implementation does nothing)
     *
     * @param line line to print removed from the drawing
     */
    default void onRemoveNewLine(Line line) {

    }

}
