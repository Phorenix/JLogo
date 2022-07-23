package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;
import it.unicam.cs.pa.jlogo.api.model.Coordinate;
import it.unicam.cs.pa.jlogo.api.model.RGBColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is a simple implementation of the interface {@link Drawing}.
 *
 * @author Luca Bianchi
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
     * This constructor calls the other one, passing a new empty ArrayList and initialize the background color
     * with the color White.
     */
    public SimpleDrawing() {
        this(new ArrayList<>(), new RGBColor(255, 255, 255));
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

    @Override
    public void addNewLine(Line line, Color fillingColor) {
        shapes.add(line);
        // Prints the new added Line
        onAddNewLine(line);

        int linesToRemove = 0;
        if ((linesToRemove = checkCreationNewPolygon(fillingColor)) > 0) {
            removeLastNLines(linesToRemove);
        }
    }

    /**
     * This utility method check just if the "last" consecutive lines can form a new polygon,
     * if they don't it just returns 0, if they do it will also create the new Polygon.
     * To do it, it checks from the last line added if they form a new polygon checking the respective ending and starting points.
     *
     * @param fillingColor filling color of the new polygon if it will be created
     * @return the number of lines to remove (because they belong the new polygon that will be created). It returns 0
     * if the last lines of the list can't form a new polygon.
     */
    private int checkCreationNewPolygon(Color fillingColor) {
        List<Line> linesNewPolygon = linesOfNewPolygon();

        // Just in case it checks that the returned lines can form a new polygon
        if (linesNewPolygon.size() < 3) {
            return 0;
        } else {
            this.shapes.add(new Polygon(linesNewPolygon, fillingColor));
            onAddNewPolygon((Polygon) this.shapes.get(this.shapes.size() - 1));
            return linesNewPolygon.size();
        }
    }

    /**
     * This method checks if the last lines of the figure can form a new polygon.
     * If they do, this method returns the lines that will form the new polygon, otherwise it returns an empty list of lines.
     * To do it, it will go backwards on the list of shapes of the drawing (but using utility methods to simplify).
     * (Note that this method is called only when it's added a new Line so the last shape is for sure a line)
     *
     * @return the lines of the new polygon or an empty list if they can't form a new polygon
     */
    private List<Line> linesOfNewPolygon() {
        List<Line> linesOfNewFigure = new ArrayList<>();
        // Adds the last added line and save the starting point
        linesOfNewFigure.add((Line) shapes.get(shapes.size() - 1));
        Coordinate lastStartingPoint = linesOfNewFigure.get(0).startingPoint();

        utilityMethodLinesOfNewPolygon(linesOfNewFigure, lastStartingPoint);

        // Checks if the new polygon can't be created or has already been closed
        if (linesOfNewFigure.size() == 0 ||
                linesOfNewFigure.get(0).startingPoint().equals(linesOfNewFigure.get(linesOfNewFigure.size() - 1).endingPoint()))
            return linesOfNewFigure;

        // Case in which the first line is maybe part of the new polygon
        else return checkFirstLine() ? linesOfNewFigure : new ArrayList<>();
    }

    /**
     * This utility method is used just to reduce the length the calling method, and it adds the lines of that will
     * form the new polygon by checking the shapes in the list, from the second-last to the first, always looking
     * for "consecutive" lines (which means that it matches the starting point of the last line with the ending
     * point of the next one)
     *
     * @param linesOfNewFigure  lines of the new polygon to create
     * @param lastStartingPoint starting point of the last line added
     */
    private void utilityMethodLinesOfNewPolygon(List<Line> linesOfNewFigure, Coordinate lastStartingPoint) {
        // Goes backwards on the list from the second-last shape
        for (int i = shapes.size() - 2; i >= 0; i--) {
            if (shapes.get(i) instanceof Line line) {
                if (line.endingPoint().equals(lastStartingPoint)) {
                    linesOfNewFigure.add(0, line);
                    lastStartingPoint = line.startingPoint();
                } else if (((Line) shapes.get(i + 1)).startingPoint().equals(((Line) shapes.get(shapes.size() - 1)).endingPoint())) {
                    // Here does the cast because the next line is for sure a Line
                    return;
                }
            } else {
                // Case where the previous Shape is a Figure, so it checks if the last line can form a polygon with the
                // other lines before
                if (!((Line) shapes.get(i + 1)).startingPoint().equals(((Line) shapes.get(shapes.size() - 1)).endingPoint()))
                    linesOfNewFigure.clear();

                return;
            }
        }
    }

    /**
     * Utility method that just checks if the first shape of the list of shapes is part of the polygon
     *
     * @return true if it's part of the new polygon
     */
    private boolean checkFirstLine() {
        if (shapes.get(0) instanceof Line firstLine) {
            // The last shape of the list of shapes must be a line (the last added), but in case it does the check
            if (shapes.get(shapes.size() - 1) instanceof Line lastLine) {
                return firstLine.startingPoint().equals(lastLine.endingPoint());
            }
        }

        return false;
    }

    /**
     * This method remove the last <code>n</code> lines (it leaves the figures)
     *
     * @param n number of lines to remove
     */
    private void removeLastNLines(int n) {
        int removedLines = 0;

        for (int i = shapes.size() - 1; i >= 0 && removedLines < n; i--) {
            if (shapes.get(i) instanceof Line) {
                // Remove and Print the line
                onRemoveNewLine((Line) shapes.remove(i));
                removedLines++;
            }
        }

    }

    @Override
    public void clear() {
        this.shapes.clear();
    }
}
