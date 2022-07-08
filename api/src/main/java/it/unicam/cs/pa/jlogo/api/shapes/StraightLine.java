package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Coordinate;
import it.unicam.cs.pa.jlogo.api.RGBColor;

import java.util.Objects;

// TODO decide if converts it into a Record

public class StraightLine implements Line {

    private final RGBColor color;

    private final Coordinate startingPoint;

    private final Coordinate endingPoint;

    private final int size;

    // TODO In teoria i controlli si possono togliere
    public StraightLine(RGBColor color, Coordinate startingPoint, Coordinate endingPoint, int size) {
        if (size < 1)
            throw new IllegalArgumentException("The size of the stroke needs to be 1 or greater");

        this.color = Objects.requireNonNull(color);
        this.startingPoint = Objects.requireNonNull(startingPoint);
        this.endingPoint = Objects.requireNonNull(endingPoint);
        this.size = size;
    }

    @Override
    public Coordinate getStartingPoint() {
        return this.startingPoint;
    }

    @Override
    public Coordinate getEndingPoint() {
        return this.endingPoint;
    }

    @Override
    public RGBColor getColor() {
        return this.color;
    }

    @Override
    public double getSize() {
        return this.size;
    }
}
