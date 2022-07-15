package it.unicam.cs.pa.jlogo.api.model;

import java.util.Objects;

/**
 * Simple implementation of the interface {@link Space}
 *
 * @author Luca Bianchi
 */
public class GridSpace implements Space {

    // This is the cursor of the current space
    private final Cursor cursor;

    // Coordinate for the position of the cursor
    private Coordinate cursorPosition;

    // Current rotation of the cursor
    private final Angle cursorDirection;

    // Width of the space
    private final double width;

    // Height of the space
    private final double height;

    // Home of this specific space
    private final Coordinate home;

    public GridSpace(Cursor cursor, Coordinate cursorPosition, Angle cursorDirection, double width, double height) {
        if (height < 0 || width < 0)
            throw new IllegalArgumentException("Illegal argument, space's dimensions should be positive");

        this.cursor = Objects.requireNonNull(cursor);
        this.cursorPosition = Objects.requireNonNull(cursorPosition);
        this.cursorDirection = Objects.requireNonNull(cursorDirection);
        this.width = width;
        this.height = height;
        this.home = new Coordinate2D(this.width / 2, this.height / 2);
    }

    /**
     * This default constructor calls the other one passing a new default cursor, the position of the home,
     * the initial rotation of the cursor at 0, and the given width and height
     *
     * @param width width of the space
     * @param height height of the space
     */
    public GridSpace(double width, double height) {
        this(new SimpleCursor(), new Coordinate2D(width / 2, height / 2), new SimpleAngle(0), width, height);
    }

    @Override
    public Cursor getCursor() {
        return this.cursor;
    }

    @Override
    public Coordinate getCursorPosition() {
        return this.cursorPosition;
    }

    @Override
    public Angle getCursorDirection() {
        return this.cursorDirection;
    }

    @Override
    public double getSpaceHeight() {
        return this.height;
    }

    @Override
    public double getSpaceWidth() {
        return this.width;
    }

    @Override
    public Coordinate getHome() {
        return this.home;
    }

    @Override
    public void moveCursor(Coordinate coordinate) {
        this.cursorPosition = coordinate;
    }

}
