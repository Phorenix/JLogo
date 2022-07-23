package it.unicam.cs.pa.jlogo.api.model;

/**
 * Simple implementation of a 2D coordinate in the space, that implements the interface {@link Coordinate}
 *
 * @author Luca Bianchi
 *
 * @param x of the coordinate
 * @param y of the coordinate
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

    /**
     * This equals method checks that the given object (that must be a Coordinate) is equals to the current Coordinate
     * but using a certain range of tolerance.
     *
     * @param obj   the reference object with which to compare
     * @return true if the 2 coordinates are equals
     */
    @Override
    public boolean equals(Object obj) {
        double epsilon = 0.00000000001;
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinate) obj;
        return (Math.abs(this.x() - that.x()) < epsilon) && (Math.abs(this.y() - that.y()) < epsilon);
    }

}
