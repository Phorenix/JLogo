package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.model.*;
import it.unicam.cs.pa.jlogo.api.model.commands.*;
import it.unicam.cs.pa.jlogo.api.model.shapes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to check the behaviour of the interface {@link CommandExecutor}
 *
 * @author Luca Bianchi
 */
public class CommandExecutorTest {

    @Test
    public void shouldMakeCursorPlot() {
        Space space = new GridSpace(1000, 1000);
        CommandExecutor executor = new SimpleCommandExecutor(space);
        executor.apply(new PlotCommand(true));
        assertTrue(space.getCursor().isPlotting());
    }

    @Test
    public void shouldMakeCursorNotPlot() {
        Space space = new GridSpace(1000, 1000);
        CommandExecutor executor = new SimpleCommandExecutor(space);
        assertFalse(space.getCursor().isPlotting());
        executor.apply(new PlotCommand(false));
        assertFalse(space.getCursor().isPlotting());
    }

    @Test
    public void shouldSetPenSizeTo4() {
        Space space = new GridSpace(1000, 1000);
        CommandExecutor executor = new SimpleCommandExecutor(space);
        executor.apply(new SetPenSizeCommand(4));
        assertEquals(4, space.getCursor().getPenSize());
    }

    @Test
    public void shouldSetFillColorToGreen() {
        Space space = new GridSpace(1000, 1000);
        CommandExecutor executor = new SimpleCommandExecutor(space);
        executor.apply(new SetFillColorCommand(new RGBColor(0, 128, 0)));
        assertEquals(new RGBColor(0, 128, 0), space.getCursor().getFillColor());
    }

    @Test
    public void shouldDrawANewLineOf10FromHome() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        executor.apply(new PlotCommand(true));
        executor.apply(new ForwardCommand(10));
        assertEquals(new StraightLine(new RGBColor(0, 0, 0), space.getHome(), new Coordinate2D(510.0, 500), 1),
                drawing.getFigures().get(0));
        assertEquals(new Coordinate2D(510.0, 500), space.getCursorPosition());
    }

    @Test
    public void shouldDrawANewSquareOf10() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        List<Command> repeatCommands = new ArrayList<>();
        executor.apply(new PlotCommand(true));
        repeatCommands.add(new ForwardCommand(10));
        repeatCommands.add(new LeftRotateCommand(new SimpleAngle(90)));
        executor.apply(new RepeatCommand(4, repeatCommands));
        assertEquals(space.getCursorPosition(), space.getHome());
        Figure square = new Polygon(
                List.of(
                        new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(500.0, 500.0), new Coordinate2D(510.0, 500.0), 1),
                        new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(510.0, 500.0), new Coordinate2D(510.0, 510.0), 1),
                        new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(510.0, 510.0), new Coordinate2D(500.0, 510.0), 1),
                        new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(500.0, 510.0), new Coordinate2D(500.0, 500.0), 1)
                ), new RGBColor(255, 255, 255)
        );
        assertEquals(square, drawing.getFigures().get(0));
    }

    @Test
    public void shouldCreateRedPentagon() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        List<Command> repeatCommands = new ArrayList<>();
        executor.apply(new PlotCommand(true));
        executor.apply(new SetFillColorCommand(new RGBColor(255, 0, 0)));
        repeatCommands.add(new ForwardCommand(10));
        repeatCommands.add(new LeftRotateCommand(new SimpleAngle(72)));
        executor.apply(new RepeatCommand(5, repeatCommands));
        assertEquals(1, drawing.getFigures().size());
        assertEquals(5, ((Figure) drawing.getFigures().get(0)).getNumberOfSegments());
        assertEquals(new RGBColor(255, 0, 0), ((Figure) drawing.getFigures().get(0)).color());
    }

    @Test
    public void shouldCreateEquilateralTriangle() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        List<Command> repeatCommands = new ArrayList<>();
        executor.apply(new PlotCommand(true));
        repeatCommands.add(new ForwardCommand(100));
        repeatCommands.add(new LeftRotateCommand(new SimpleAngle(120)));
        executor.apply(new RepeatCommand(3, repeatCommands));
        assertEquals(1, drawing.getFigures().size());
        assertEquals(3, ((Figure) drawing.getFigures().get(0)).getNumberOfSegments());
    }

    @Test
    public void shouldClipLineTooLong() {
        Space space = new GridSpace(100, 100);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        executor.apply(new PlotCommand(true));
        executor.apply(new ForwardCommand(200));
        assertEquals(new Coordinate2D(100.0, 50.0), space.getCursorPosition());
        assertEquals(
                new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(50.0, 50.0), new Coordinate2D(100, 50.0), 1),
                drawing.getFigures().get(0)
        );
    }

    @Test
    public void shouldCreateNewLineByMovingToHome() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        executor.apply(new LeftRotateCommand(new SimpleAngle(360)));
        executor.apply(new BackwardCommand(100));
        executor.apply(new PlotCommand(true));
        executor.apply(new HomeCommand());
        assertEquals(1, drawing.getFigures().size());
        assertEquals(
                new StraightLine(new RGBColor(0, 0, 0), new Coordinate2D(400.0, 500.0), new Coordinate2D(500.0, 500.0), 1),
                drawing.getFigures().get(0)
        );
    }

    @Test
    public void shouldClearScreenButLeaveTheSameConfiguration() {
        Space space = new GridSpace(1000, 1000);
        Drawing drawing = new SimpleDrawing();
        CommandExecutor executor = new SimpleCommandExecutor(drawing, space);
        executor.apply(new SetPenSizeCommand(10));
        executor.apply(new PlotCommand(true));
        executor.apply(new SetPenColorCommand(new RGBColor(100, 100, 100)));
        executor.apply(new SetScreenColorCommand(new RGBColor(200, 200, 200)));
        executor.apply(new ForwardCommand(100));
        executor.apply(new ClearScreenCommand());
        assertEquals(new ArrayList<>(), drawing.getFigures());
        assertEquals(new RGBColor(100, 100, 100), space.getCursor().getLineColor());
        assertEquals(10, space.getCursor().getPenSize());
        assertEquals(new RGBColor(200, 200, 200), drawing.getBackgroundColor());
    }

}
