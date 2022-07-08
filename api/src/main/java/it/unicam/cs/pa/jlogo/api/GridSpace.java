package it.unicam.cs.pa.jlogo.api;

import java.util.Objects;

/**
 * Simple implementation of the interface {@link Space}
 */
public class GridSpace implements Space {

    private final Cursor cursor;

    private Coordinate cursorPosition;

    private final Angle cursorDirection;

    private final double width;

    private final double height;

    private final Coordinate home;

    public GridSpace(Cursor cursor, Coordinate cursorPosition, Angle cursorDirection, double width, double height) {
        if (height < 0 || width < 0)
            throw new IllegalArgumentException("Illegal argument, space's dimensions should be positive");

        this.cursor = Objects.requireNonNull(cursor);
        this.cursorPosition = Objects.requireNonNull(cursorPosition);
        this.cursorDirection = Objects.requireNonNull(cursorDirection);
        this.width = width;
        this.height = height;
        this.home = new Coordinate(this.width / 2, this.height / 2);
    }

    public GridSpace(double width, double height) {
        this(new SimpleCursor(), new Coordinate(width / 2, height / 2), new Angle(0), width, height);
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
    public void moveCursorToHome() {
        moveCursor(this.getHome());
    }

    @Override
    public void moveCursor(Coordinate coordinate) {
        this.cursorPosition = coordinate;
    }

}
