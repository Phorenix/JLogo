package it.unicam.cs.pa.jlogo.api.shapes;

import java.util.List;

public interface Figure extends Shape {

    int getNumberOfSegments();

    List<Line> lines();

}
