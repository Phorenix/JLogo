package it.unicam.cs.pa.jlogo.api;

/**
 * This interface represents a Cursor in a Logo application, so it has the responsibility to manage the color of
 * the printing line and of the closed area. Also check if the cursor is printing or not.
 *
 * {@author Luca Bianchi}
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
     * Change the color of the printed line
     */
    void setPenColor(Color color);

    /**
     * Returns the {@link Color} of the area when closed
     *
     * @return the {@link Color} of the area when closed
     */
    Color getAreaColor();

    /**
     * Change the color of the area when closed
     */
    void setFillColor(Color color);

}
