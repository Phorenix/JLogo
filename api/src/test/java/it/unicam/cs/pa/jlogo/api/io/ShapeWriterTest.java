package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.Coordinate2D;
import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import it.unicam.cs.pa.jlogo.api.model.shapes.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class to check the usage of the interface {@link ShapeWriter}
 *
 * @author Luca Bianchi
 */
public class ShapeWriterTest {

    private ShapeWriter writer = new DefaultShapeWriter();

    @Test
    public void shouldReturnStringRepresentationOfNewLine() {
        Line line = new StraightLine(new RGBColor(100, 100, 100), new Coordinate2D(50, 50),
                new Coordinate2D(200, 200), 10);
        String expectedLineRepresentation = "LINE 50.0 50.0 200.0 200.0 100 100 100 10\n";
        assertEquals(writer.stringOf(line), expectedLineRepresentation);
    }

    @Test
    public void shouldReturnStringRepresentationOfNewPolygon() {
        Line line1 = new StraightLine(new RGBColor(100, 100, 100), new Coordinate2D(50, 50),
                new Coordinate2D(200, 200), 10);
        Line line2 = new StraightLine(new RGBColor(100, 100, 100), new Coordinate2D(200, 200),
                new Coordinate2D(400, 400), 10);
        Line line3 = new StraightLine(new RGBColor(100, 100, 100), new Coordinate2D(400, 400),
                new Coordinate2D(50, 50), 10);
        List<Line> figureLines = new ArrayList<>();
        figureLines.add(line1);
        figureLines.add(line2);
        figureLines.add(line3);
        Figure figure = new Polygon(figureLines, new RGBColor(255, 255, 255));

        String expectedFigureRepresentation = """
                POLYGON 3 255 255 255
                50.0 50.0 100 100 100 10
                200.0 200.0 100 100 100 10
                400.0 400.0 100 100 100 10
                """;

        assertEquals(writer.stringOf(figure), expectedFigureRepresentation);
    }
}
