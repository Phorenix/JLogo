package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;
import it.unicam.cs.pa.jlogo.api.Coordinate;

/**
 * This interface represents a Line to draw in the drawing.
 * It will also be used to form a Figure.
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
