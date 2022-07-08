package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.RGBColor;

import java.util.List;

public interface Drawing {

    double getHeight();

    double getWidth();

    RGBColor getBackgroundColor();

    void setBackgroundColor(RGBColor color);

    List<Shape> getFigures();

    void addNewShape(Shape shape);

    void removeShape(Shape shape);

    /**
     * This method clears the shapes in the drawing, but it doesn't clear the previous configurations
     */
    void clear();

}
