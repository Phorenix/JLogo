package it.unicam.cs.pa.jlogo.api;

import java.util.Objects;

/**
 * Simple implementation of a cursor for a space.
 */
public class SimpleCursor implements Cursor {

    // Boolean for the plot, true if it needs to plot a line, false instead shouldn't plot any line
    private boolean plot;

    // Color of the line
    private Color lineColor;

    // Color of the figure created when closed
    private Color areaColor;

    public SimpleCursor(boolean plot, Color lineColor, Color areaColor) {
        this.plot = plot;
        this.lineColor = Objects.requireNonNull(lineColor);
        this.areaColor = Objects.requireNonNull(areaColor);
    }

    /**
     * This default constructor calls the other one initializing the plot with false, the color of the line with black
     * and the color of the closed area with white.
     */
    public SimpleCursor() {
        this(false, new RGBColor(0, 0, 0), new RGBColor(255, 255, 255));
    }

    @Override
    public boolean isPlotting() {
        return this.plot;
    }

    @Override
    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    @Override
    public Color getLineColor() {
        return this.lineColor;
    }

    @Override
    public void setPenColor(Color color) {
        this.lineColor = color;
    }

    @Override
    public Color getAreaColor() {
        return this.areaColor;
    }

    @Override
    public void setFillColor(Color color) {
        this.areaColor = color;
    }

}
