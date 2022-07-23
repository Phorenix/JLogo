package it.unicam.cs.pa.jlogo.api.model;

/**
 * This interface represents a Cursor in a Logo application, so it has the responsibility to manage the color of
 * the printing line (and size) and of the closed area. Also keeps track if the cursor is printing or not.
 *
 * @author Luca Bianchi
 */
public interface Cursor {

    /**
     * Returns <code>true</code> if the cursor print a line by moving
     *
     * @return <code>true</code> if the cursor print a line by moving
     */
    boolean isPlotting();

    /**
     * Set the variable plot
     *
     * @param plot if true it means that cursor needs to print the line when moved
     */
    void setPlot(boolean plot);

    /**
     * Returns the {@link Color} of the line printed by the cursor
     *
     * @return the {@link Color} of the line printed by the cursor
     */
    Color getLineColor();

    /**
     * Change the {@link Color of the printed line
     *
     * @param color new {@link Color} of the next lines
     */
    void setPenColor(Color color);

    /**
     * Returns the {@link Color} of the area when closed
     *
     * @return the {@link Color} of the area when closed
     */
    Color getFillColor();

    /**
     * Change the {@link Color} of the area when closed
     *
     * @param color new {@link Color} to fill a closed area
     */
    void setFillColor(Color color);

    /**
     * Returns the size of the pen
     *
     * @return the size of the pen
     */
    int getPenSize();

    /**
     * Set the size of the next lines
     *
     * @param penSize new size of the pen
     */
    void setPenSize(int penSize);

}
