package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;

import java.util.List;

/**
 * This interface represents a possible figure in the drawing.
 * A figure is basically a sequence of lines that closes in the starting point of the first line.
 *
 * @author Luca Bianchi
 */
public interface Figure extends Shape {

    /**
     * Returns the number of lines that compose the sequence
     *
     * @return the number of lines that compose the sequence
     */
    int getNumberOfSegments();

    /**
     * Returns the sequence of lines in the sequence
     *
     * @return the sequence of lines in the sequence
     */
    List<Line> lines();

    /**
     * Returns the color of the closed area
     *
     * @return the color of the closed area
     */
    Color color();

}
