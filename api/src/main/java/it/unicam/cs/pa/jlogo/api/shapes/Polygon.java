package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;

import java.util.List;

/**
 * An implementation of the interface {@link Figure} that represents a polygon, that is a figure composed of
 * straight lines.
 * Is a record because once passed the lines of the polygon, they can't be changed.
 *
 * @param lines sequence of lines that makes the polygon
 */
public record Polygon(List<Line> lines, Color color) implements Figure {

    /**
     * Check if the list contacting the lines is null or if the passed color is null
     *
     * @param lines list containing the lines
     * @param color color of the closed area
     */
    public Polygon {
        if(lines == null || color == null) {
            throw new NullPointerException("Arguments of a new Polygon can't be null");
        }
    }

    @Override
    public int getNumberOfSegments() {
        return this.lines.size();
    }

}
