package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;
import it.unicam.cs.pa.jlogo.api.model.Coordinate2D;
import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test the behavior of the interface {@link Drawing}
 *
 * @author Luca Bianchi
 */
public class DrawingTest {

    private Color backgroundColor = new RGBColor(0, 0, 0);

    private Color fillingColor = new RGBColor(255, 255, 255);

    private Line line1 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(10.0, 10.0),
            new Coordinate2D(100.0, 100.0), 1);
    private Line line2 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(100.0, 100.0),
            new Coordinate2D(50.0, 100.0), 1);
    private Line line3 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(50.0, 100.0),
            new Coordinate2D(10.0, 10.0), 1);

    @Test
    public void shouldThrowExceptionOnNullArguments() {
        assertThrows(NullPointerException.class, () -> new SimpleDrawing(null, new RGBColor(0, 0, 0)));
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(0.0, 0.0),
                new Coordinate2D(50.0, 50.0), 1));
        assertThrows(NullPointerException.class, () -> new SimpleDrawing(shapes, null));
    }

    @Test
    public void testClearMethod() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(line1);
        shapes.add(line2);
        shapes.add(line3);
        Drawing drawing = new SimpleDrawing(shapes, backgroundColor);
        assertEquals(List.of(line1, line2, line3), drawing.getFigures());
        drawing.clear();
        assertEquals(drawing.getFigures(), new ArrayList<>());
    }

    @Test
    public void shouldCreateOnlyNewLine() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(line1);
        Drawing drawing = new SimpleDrawing(shapes, backgroundColor);
        assertEquals(drawing.getFigures(), List.of(line1));
        assertTrue(drawing.getFigures().get(0) instanceof Line);
    }

    @Test
    public void shouldAddOnlyNewLine() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        assertEquals(drawing.getFigures(), List.of(line1));
        assertTrue(drawing.getFigures().get(0) instanceof Line);
    }

    @Test
    public void shouldCreateNewPolygon() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);
        assertEquals(1, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Figure);
        assertEquals(drawing.getFigures().get(0), new Polygon(List.of(line1, line2, line3), fillingColor));
    }

    @Test
    public void shouldNotCreateNewPolygon() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line3, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line1, fillingColor);
        assertEquals(3, drawing.getFigures().size());
        assertEquals(drawing.getFigures(), List.of(line3, line2, line1));
    }

    @Test
    public void shouldCreateNewPolygonAndLeaveTheFirstLines() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);
        assertEquals(3, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Line);
        assertTrue(drawing.getFigures().get(1) instanceof Line);
        assertTrue(drawing.getFigures().get(2) instanceof Figure);
        assertEquals(drawing.getFigures().get(0), line1);
        assertEquals(drawing.getFigures().get(1), line2);
        assertEquals(drawing.getFigures().get(2), new Polygon(List.of(line1, line2, line3), fillingColor));
    }

    @Test
    public void shouldCreateANewPolygonAndANewLine() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);
        assertEquals(1, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Figure);
        assertEquals(drawing.getFigures().get(0), new Polygon(List.of(line1, line2, line3), fillingColor));
        drawing.addNewLine(line1, fillingColor);
        assertEquals(2, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(1) instanceof Line);
        assertEquals(line1, drawing.getFigures().get(1));
    }

    @Test
    public void shouldCreateANewPolygonAnd2NewLines() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);
        assertEquals(1, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Figure);
        assertEquals(drawing.getFigures().get(0), new Polygon(List.of(line1, line2, line3), fillingColor));
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        assertEquals(3, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(1) instanceof Line);
        assertTrue(drawing.getFigures().get(2) instanceof Line);
        assertEquals(line1, drawing.getFigures().get(1));
        assertEquals(line2, drawing.getFigures().get(2));
    }

    @Test
    public void shouldCreate2NewPolygons() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);
        assertEquals(1, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Figure);
        assertEquals(drawing.getFigures().get(0), new Polygon(List.of(line1, line2, line3), fillingColor));
        drawing.addNewLine(line3, fillingColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        assertEquals(2, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(1) instanceof Figure);
        assertEquals(drawing.getFigures().get(1), new Polygon(List.of(line3, line1, line2), fillingColor));
    }

    @Test
    public void shouldNotCreateNewPolygonBecauseLinesAreNotConsecutive() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        // Adds new Polygon
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);

        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(line3, fillingColor);

        assertEquals(4, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Line);
        assertTrue(drawing.getFigures().get(1) instanceof Figure);
        assertTrue(drawing.getFigures().get(2) instanceof Line);
        assertTrue(drawing.getFigures().get(3) instanceof Line);
        assertEquals(line1, drawing.getFigures().get(0));
        assertEquals(drawing.getFigures().get(1), new Polygon(List.of(line1, line2, line3), fillingColor));
        assertEquals(line2, drawing.getFigures().get(2));
        assertEquals(line3, drawing.getFigures().get(3));
    }

    @Test
    public void shouldNotCreateNewPolygonWith2Lines() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        assertEquals(2, drawing.getFigures().size());
        assertTrue(drawing.getFigures().get(0) instanceof Line);
        assertTrue(drawing.getFigures().get(1) instanceof Line);
        assertEquals(line1, drawing.getFigures().get(0));
        assertEquals(line2, drawing.getFigures().get(1));
    }

    @Test
    public void shouldCreateNewPolygonWith4Lines() {
        Drawing drawing = new SimpleDrawing(new ArrayList<>(), backgroundColor);
        Line tempLine3 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(50.0, 100.0),
                new Coordinate2D(20.0, 100.0), 1);
        Line tempLine4 = new StraightLine(new RGBColor(255, 255, 255), new Coordinate2D(20.0, 100.0),
                new Coordinate2D(10.0, 10.0), 1);
        drawing.addNewLine(line1, fillingColor);
        drawing.addNewLine(line2, fillingColor);
        drawing.addNewLine(tempLine3, fillingColor);
        drawing.addNewLine(tempLine4, fillingColor);
        assertEquals(1, drawing.getFigures().size());
        assertEquals(drawing.getFigures().get(0), new Polygon(List.of(line1, line2, tempLine3, tempLine4), fillingColor));
    }

}
