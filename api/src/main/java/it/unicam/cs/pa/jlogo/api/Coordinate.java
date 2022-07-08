package it.unicam.cs.pa.jlogo.api;

// TODO check if it needs to be changed to class and use the epsilon thing

public record Coordinate(double x, double y) {

    public Coordinate {

        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Coordinate's x and y needs to be positive");

    }

}
