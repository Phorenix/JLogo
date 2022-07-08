package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Coordinate;
import it.unicam.cs.pa.jlogo.api.RGBColor;

public interface Line extends Shape {

    Coordinate getStartingPoint();

    Coordinate getEndingPoint();

    RGBColor getColor();

    double getSize();

}
