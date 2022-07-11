package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;

import java.util.List;

/**
 * This interface represents a possible figure in the drawing.
 * A figure is basically a sequence of lines that close in the starting point of the first line.
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
