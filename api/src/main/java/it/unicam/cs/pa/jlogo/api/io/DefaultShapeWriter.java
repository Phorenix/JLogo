package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.shapes.Figure;
import it.unicam.cs.pa.jlogo.api.model.shapes.Line;
import it.unicam.cs.pa.jlogo.api.model.shapes.Shape;

/**
 * Default implementation of a {@link ShapeWriter}
 *
 * @author Luca Bianchi
 */
public class DefaultShapeWriter implements ShapeWriter {
    @Override
    public String stringOf(Shape shape) {
        // Check if the given shape is an instance of a Line or a Figure
        if (shape instanceof Line line) return lineStringRepresentation(line);
        else if (shape instanceof Figure figure) return figureStringRepresentation(figure);
        else throw new IllegalArgumentException();
        //else throw new InvalidShapeException("The shape must be a line or a figure");
    }

    /**
     * The representation for a Line is: LINE <x1> <y1> <x2> <y2> <b1> <b2> <b3> <size>
     *
     * @param line the line it needs to return as string
     * @return the string representation of the given line
     */
    private String lineStringRepresentation(Line line) {
        return "LINE " + line.startingPoint().x() + " " + line.startingPoint().y() + " "
                + line.endingPoint().x() + " " + line.endingPoint().y() + " "
                + line.color().red() + " " + line.color().green() + " " + line.color().blue() + " "
                + line.size() + "\n";
    }

    /**
     * Representation of a figure in the drawing.
     * The first line has the following representation: POLYGON <N> <b1> <b2> <b3>
     *
     * @param figure the figure it needs to return as a whole string
     * @return the string representation of the given figure
     */
    private String figureStringRepresentation(Figure figure) {
        StringBuilder stringToReturn = new StringBuilder("POLYGON " + figure.getNumberOfSegments() + " "
                + figure.color().red() + " " + figure.color().green() + " " + figure.color().blue() + "\n");

        for (Line line : figure.lines()) {
            stringToReturn.append(lineOfFigureRepresentation(line));
        }

        return stringToReturn.toString();

    }

    /*
     * This utility method is different from lineStringRepresentation() because the line in a figure have a different
     * representation, that is <x0> <y0> <fb10> <fb20> <fb30> <size0>
     */
    private String lineOfFigureRepresentation(Line line) {
        return line.startingPoint().x() + " " + line.startingPoint().y() + " "
                + line.color().red() + " " + line.color().green() + " " + line.color().blue() + " "
                + line.size() + "\n";
    }
}
