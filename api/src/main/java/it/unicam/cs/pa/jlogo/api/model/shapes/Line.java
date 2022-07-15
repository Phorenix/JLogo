package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;
import it.unicam.cs.pa.jlogo.api.model.Coordinate;

/**
 * This interface represents a Line to draw in the drawing.
 * It will also be used to form a Figure.
 *
 * @author Luca Bianchi
 */
public interface Line extends Shape {

    /**
     * Returns the starting coordinate of the line
     *
     * @return the starting coordinate of the line
     */
    Coordinate startingPoint();

    /**
     * Returns the ending coordinate of the line
     *
     * @return the ending coordinate of the line
     */
    Coordinate endingPoint();

    /**
     * Returns the color of the line
     *
     * @return the color of the line
     */
    Color color();

    /**
     * Returns the size of the stroke
     *
     * @return the size of the stroke
     */
    int size();

}
