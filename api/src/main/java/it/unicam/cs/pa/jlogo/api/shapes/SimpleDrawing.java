package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;
import it.unicam.cs.pa.jlogo.api.RGBColor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a simple implementation of the interface {@link Drawing}.
 */
public class SimpleDrawing implements Drawing {

    // Where will be stored the shapes
    private final List<Shape> shapes;

    // Background color of the drawing
    private Color backgroundColor;

    public SimpleDrawing(List<Shape> shapes, Color backgroundColor) {
        this.shapes = shapes;
        this.backgroundColor = backgroundColor;
    }

    /**
     * This constructor calls the default one, passing a new empty ArrayList and initialize the background color
     * with the color White.
     */
    public SimpleDrawing() {
        this(new ArrayList<>(), new RGBColor(0, 0, 0));
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    @Override
    public List<Shape> getFigures() {
        return this.shapes;
    }

    // TODO implement method
    @Override
    public void addNewShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removeShape(Line line) {
        // TODO Not sure
        this.shapes.remove(line);
    }

    @Override
    public void clear() {
        this.shapes.clear();
    }
}
