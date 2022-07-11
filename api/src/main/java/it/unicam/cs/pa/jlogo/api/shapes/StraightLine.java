package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;
import it.unicam.cs.pa.jlogo.api.Coordinate;

import java.util.Objects;

/**
 * This record represents a straight line in the drawing.
 * (This is also a record because once created it shouldn't be changed anymore)
 *
 * @param color color of the line
 * @param startingPoint starting coordinate of the line
 * @param endingPoint ending coordinate of the line
 * @param size size of the stroke of the line
 */
public record StraightLine(Color color, Coordinate startingPoint, Coordinate endingPoint, int size) implements Line {

    // TODO In teoria i controlli si possono togliere

    /**
     * In the constructor are executed simple checks for the passed arguments.
     *
     * @param color color of the line
     * @param startingPoint starting coordinate of the line
     * @param endingPoint ending coordinate of the line
     * @param size size of the stroke of the line
     */
    public StraightLine(Color color, Coordinate startingPoint, Coordinate endingPoint, int size) {
        if (size < 1)
            throw new IllegalArgumentException("The size of the stroke needs to be 1 or greater");

        this.color = Objects.requireNonNull(color);
        this.startingPoint = Objects.requireNonNull(startingPoint);
        this.endingPoint = Objects.requireNonNull(endingPoint);
        this.size = size;
    }
}
