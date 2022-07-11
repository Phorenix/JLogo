package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.shapes.Shape;

import java.util.List;
import java.util.stream.Collectors;

public interface ShapeWriter {

    String stringOf(Shape shape);

    default String stringOf(List<Shape> shapeList) {
        return shapeList.stream().map(this::stringOf).collect(Collectors.joining("\n"));
    }

}
