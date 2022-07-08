package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.RGBColor;

import java.util.ArrayList;
import java.util.List;

public class SimpleDrawing implements Drawing {

    private final double width;

    private final double height;

    private final List<Shape> shapes;

    private RGBColor backgroundColor;

    public SimpleDrawing(double width, double height, List<Shape> shapes, RGBColor backgroundColor) {
        this.width = width;
        this.height = height;
        this.shapes = shapes;
        this.backgroundColor = backgroundColor;
    }

    public SimpleDrawing(double width, double height) {
        this(width, height, new ArrayList<>(), new RGBColor(0, 0, 0));
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public RGBColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public void setBackgroundColor(RGBColor color) {
        this.backgroundColor = color;
    }

    @Override
    public List<Shape> getFigures() {
        return this.shapes;
    }

    @Override
    public void addNewShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        // TODO Not sure
        this.shapes.remove(shape);
    }

    @Override
    public void clear() {
        this.shapes.clear();
    }
}
