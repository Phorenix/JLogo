package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.shapes.Figure;
import it.unicam.cs.pa.jlogo.api.shapes.Line;
import it.unicam.cs.pa.jlogo.api.shapes.Shape;

public class DefaultShapeWriter implements ShapeWriter {
    @Override
    public String stringOf(Shape shape) {
        if (shape instanceof Line line) return lineStringRepresentation(line);
        else if (shape instanceof Figure figure) return figureStringRepresentation(figure);
        else throw new IllegalArgumentException();
    }

    private String lineStringRepresentation(Line line) {
        return "LINE " + line.startingPoint().x() + " " + line.startingPoint().y() + " "
                + line.endingPoint().x() + " " + line.endingPoint().y() + " "
                + line.color().red() + " " + line.color().green() + " " + line.color().blue() + " "
                + line.size() + "\n";
    }

    private String figureStringRepresentation(Figure figure) {
        String stringToReturn = "POLYGON " + figure.getNumberOfSegments() + " "
                + figure.color().red() + " " + figure.color().green() + " " + figure.color().blue() + "\n";

        // TODO String Builder?
        for (Line line : figure.lines()) {
            stringToReturn += lineOfFigureRepresentation(line);
        }

        return stringToReturn;

    }

    private String lineOfFigureRepresentation(Line line) {
        return line.startingPoint().x() + " " + line.startingPoint().y() + " "
                + line.color().red() + " " + line.color().green() + " " + line.color().blue() + " "
                + line.size() + "\n";
    }
}
