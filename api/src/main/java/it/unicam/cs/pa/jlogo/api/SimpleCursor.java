package it.unicam.cs.pa.jlogo.api;

import java.util.Objects;

public class SimpleCursor implements Cursor {

    private boolean plot;

    private RGBColor lineColor;

    private RGBColor areaColor;

    public SimpleCursor(boolean plot, RGBColor lineColor, RGBColor areaColor) {
        this.plot = plot;
        this.lineColor = Objects.requireNonNull(lineColor);
        this.areaColor = Objects.requireNonNull(areaColor);
    }

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
    public RGBColor getLineColor() {
        return this.lineColor;
    }

    @Override
    public void setPenColor(RGBColor color) {
        this.lineColor = color;
    }

    @Override
    public RGBColor getAreaColor() {
        return this.areaColor;
    }

    @Override
    public void setFillColor(RGBColor color) {
        this.areaColor = color;
    }

}
