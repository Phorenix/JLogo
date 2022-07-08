package it.unicam.cs.pa.jlogo.api;

/**
 * This interface represents a bi dimensional space (a grid), in which we have a cursor.
 * Also has the responsibility to track the position and direction of the cursor inside the space.
 */
public interface Space {

    /**
     * Returns the cursor associated with the space
     *
     * @return the cursor associated with the space
     */
    Cursor getCursor();

    /**
     * Returns the position of the cursor
     *
     * @return the position of the cursor
     */
    Coordinate getCursorPosition();

    /**
     * Returns the direction (the Angle) of the cursor
     *
     * @return the direction (the Angle) of the cursor
     */
    Angle getCursorDirection();

    /**
     * Returns the space's height
     *
     * @return the space's height
     */
    double getSpaceHeight();

    /**
     * Returns the space's width
     *
     * @return the space's width
     */
    double getSpaceWidth();

    /**
     * Returns the home of the space
     *
     * @return Returns the home of the space
     */
    Coordinate getHome();

    /**
     * Return the cursor at the <code>home</code> position of the space
     */
    void moveCursorToHome();

    /**
     * Move the cursor to a given {@link Coordinate}
     *
     * @param coordinate where to move the cursor
     */
    void moveCursor(Coordinate coordinate);

}
