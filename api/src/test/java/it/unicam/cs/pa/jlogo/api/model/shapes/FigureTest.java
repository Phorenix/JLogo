package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;
import it.unicam.cs.pa.jlogo.api.model.Coordinate2D;
import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to test the behavior of the interface {@link Figure}
 *
 * @author Luca Bianchi
 */
public class FigureTest {

    private Color color = new RGBColor(0, 0, 0);

    private Line line1 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(10.0, 10.0),
            new Coordinate2D(100.0, 100.0), 1);
    private Line line2 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(100.0, 100.0),
            new Coordinate2D(50.0, 100.0), 1);
    private Line line3 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(50.0, 100.0),
            new Coordinate2D(10.0, 10.0), 1);

    @Test
    public void shouldReturnCorrectNumberOfSegments() {
        List<Line> figureLines = new ArrayList<>();
        figureLines.add(line1);
        figureLines.add(line2);
        figureLines.add(line3);
        Figure polygon = new Polygon(figureLines, color);
        assertEquals(polygon.getNumberOfSegments(), 3);
    }

    @Test
    public void shouldThrowExceptionNullArguments() {
        List<Line> figureLines = new ArrayList<>();
        figureLines.add(line1);
        figureLines.add(line2);
        figureLines.add(line3);
        assertThrows(NullPointerException.class, () -> new Polygon(figureLines, null));
        assertThrows(NullPointerException.class, () -> new Polygon(null, color));
    }

}
