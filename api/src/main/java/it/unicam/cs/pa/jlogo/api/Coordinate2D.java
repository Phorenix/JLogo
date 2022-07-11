package it.unicam.cs.pa.jlogo.api;

// TODO check if it needs to be changed to class and use the epsilon thing

/**
 * Simple implementation of a 2D coordinate in the space, that implements the interface Coordinate
 * @param x value of the x of a coordinate
 * @param y value of the y of a coordinate
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

}
