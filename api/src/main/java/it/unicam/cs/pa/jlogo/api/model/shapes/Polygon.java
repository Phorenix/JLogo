package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;

import java.util.List;

/**
 * An implementation of the interface {@link Figure} that represents a polygon, that is a figure composed of
 * straight lines.
 * Is a record because once passed the lines of the polygon, they can't be changed.
 *
 * @param lines sequence of lines that makes the polygon
 * @param color color of the closed area
 *
 * @author Luca Bianchi
 */
public record Polygon(List<Line> lines, Color color) implements Figure {

    /**
     * Check if the list containing the lines is null (or empty) or if the passed color is null
     *
     * @param lines list containing the lines
     * @param color color of the closed area
     */
    public Polygon {
        if (lines == null || color == null) {
            throw new NullPointerException("Arguments of a new Polygon can't be null");
        }

        if (lines.isEmpty())
            throw new IllegalArgumentException("The given list of lines can't be empty");
    }

    @Override
    public int getNumberOfSegments() {
        return this.lines.size();
    }

}
