package it.unicam.cs.pa.jlogo.api.model;

/**
 * This interface represents a simple Coordinate in the bi-dimensional space of a Logo application.
 * In this implementation of a coordinate, both values are double.
 *
 * @author Luca Bianchi
 */
public interface Coordinate {

    /**
     * Returns the x of the coordinate
     *
     * @return the x of the coordinate
     */
    double x();

    /**
     * Returns the y of the coordinate
     *
     * @return the y of the coordinate
     */
    double y();

}
