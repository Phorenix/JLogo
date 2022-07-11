package it.unicam.cs.pa.jlogo.api.shapes;

import it.unicam.cs.pa.jlogo.api.Color;
import it.unicam.cs.pa.jlogo.api.Coordinate;
import it.unicam.cs.pa.jlogo.api.RGBColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is a simple implementation of the interface {@link Drawing}.
 */
public class SimpleDrawing implements Drawing {

    // Where will be stored the shapes
    private final List<Shape> shapes;

    // Background color of the drawing
    private Color backgroundColor;

    public SimpleDrawing(List<Shape> shapes, Color backgroundColor) {
        this.shapes = Objects.requireNonNull(shapes);
        this.backgroundColor = Objects.requireNonNull(backgroundColor);
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
        if (shape instanceof Line line) addNewLine(line);
        else if (shape instanceof Figure figure) addNewFigure(figure);
        else throw new IllegalArgumentException();
    }

    private void addNewLine(Line line) {
        shapes.add(line);

        int linesToRemove = 0;
        if ((linesToRemove = checkCreationNewPolygon()) > 0) {
            removeLastNLines(linesToRemove);
        }
    }

    /**
     * This utility method check just if the "last" consecutive lines can form a new polygon,
     * if they don't it just returns 0.
     *
     * @return the number of lines to remove (because they belong the new polygon that will be created). It returns 0
     *          if the last lines of the list can't form a new polygon.
     */
    private int checkCreationNewPolygon() {
        int numLinesToRemove = 0;
        List<Line> linesOfNewFigure = new ArrayList<>();
        Coordinate lastStartingPoint = null;
        if (shapes.get(shapes.size() - 1) instanceof Line lastLine)
            lastStartingPoint = lastLine.startingPoint();

        for (int i = shapes.size() - 2; i >= 0; i--) {
            if (shapes.get(i) instanceof Line line) {
                if (line.endingPoint().equals(lastStartingPoint)) {
                    numLinesToRemove++;
                    linesOfNewFigure.add(line);
                    lastStartingPoint = line.startingPoint();
                } else if (((Line) shapes.get(i + 1)).startingPoint().equals(((Line) shapes.get(shapes.size() - 1)).endingPoint())) {
                    this.addNewFigure(new Polygon(linesOfNewFigure, null));
                }
            } else {
                // Case where the next Shape is a Figure
                return 0;
            }
        }

        return numLinesToRemove;
    }

    // TODO Stream?
    private void removeLastNLines(int n) {
        int removedLines = 0;

        for (int i = shapes.size() - 1; i >= 0 && removedLines <= n; i--) {
            if (shapes.get(i) instanceof Line) {
                shapes.remove(i);
                removedLines++;
            }
        }

    }

    private void addNewFigure(Figure figure) {
        this.shapes.add(figure);
    }


    @Override
    public void clear() {
        this.shapes.clear();
    }
}
