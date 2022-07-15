package it.unicam.cs.pa.jlogo.api.model;

import java.util.Objects;

/**
 * Simple implementation of a 2D coordinate in the space, that implements the interface Coordinate
 *
 * @author Luca Bianchi
 */
public record Coordinate2D(double x, double y) implements Coordinate {
    /**
     * In this constructor is only checked if the x and y are valid (both should be positive).
     *
     * @param x of the given coordinate
     * @param y of the given coordinate
     */
    public Coordinate2D {

        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Coordinate's x and y needs to be positive");

    }

    @Override
    public boolean equals(Object obj) {
        double epsilon = 0.00000000001;
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinate2D) obj;
        return (Math.abs(this.x() - that.x()) < epsilon) && (Math.abs(this.y() - that.y()) < epsilon);
    }

}
