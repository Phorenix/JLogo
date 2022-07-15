package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import it.unicam.cs.pa.jlogo.api.model.SimpleAngle;
import it.unicam.cs.pa.jlogo.api.model.commands.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to check the usage of the interface {@link CommandParser}
 *
 * @author Luca Bianchi
 */
public class CommandParserTest {

    private final CommandParser parser = new DefaultCommandParser();

    @Test
    public void shouldCreateNewForwardCommand() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "FORWARD 10";
        List<Command> shouldCreateCommands = new ArrayList<>();
        shouldCreateCommands.add(new ForwardCommand(10));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldNotCreateNewForwardCommand() {
        String content1 = "FORWARD 10 11";
        assertThrows(InvalidNumberArgumentsException.class, () -> parser.parse(content1));
        String content2 = "FORWARD";
        assertThrows(InvalidNumberArgumentsException.class, () -> parser.parse(content2));
    }

    @Test
    public void shouldNotCreateANewCommand() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "TEST";
        assertThrows(InvalidCommandException.class, () -> parser.parse(content));
    }

    @Test
    public void shouldCreateNewHomeCommand() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "HOME";
        List<Command> shouldCreateCommands = new ArrayList<>();
        shouldCreateCommands.add(new HomeCommand());
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldCreateNewSetPenColor() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "SETPENCOLOR 255 255 255";
        List<Command> shouldCreateCommands = new ArrayList<>();
        shouldCreateCommands.add(new SetPenColorCommand(new RGBColor(255, 255, 255)));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldNotCreateNewSetPenColor() {
        String content = "SETPENCOLOR 256 255 255";
        assertThrows(IllegalArgumentException.class, () -> parser.parse(content));
    }

    @Test
    public void shouldCreateNewLeftCommand() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "LEFT 50";
        List<Command> shouldCreateCommands = new ArrayList<>();
        shouldCreateCommands.add(new LeftRotateCommand(new SimpleAngle(50)));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldNotCreateNewLeftCommand() {
        String content = "LEFT 370";
        assertThrows(IllegalArgumentException.class, () -> parser.parse(content));
    }

    @Test
    public void shouldCreateNewRepeatCommand() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "RIPETI 4 [ FORWARD 50 ]";
        List<Command> shouldCreateCommands = new ArrayList<>();
        List<Command> repeatCommands = new ArrayList<>();
        repeatCommands.add(new ForwardCommand(50));
        shouldCreateCommands.add(new RepeatCommand(4, repeatCommands));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldCreatedCommands() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = "RIPETI 4 [ FORWARD 50 BACKWARD 50 ]\nCLEARSCREEN\nRIGHT 200";
        List<Command> shouldCreateCommands = new ArrayList<>();
        List<Command> repeatCommands = new ArrayList<>();
        repeatCommands.add(new ForwardCommand(50));
        repeatCommands.add(new BackwardCommand(50));
        shouldCreateCommands.add(new RepeatCommand(4, repeatCommands));
        shouldCreateCommands.add(new ClearScreenCommand());
        shouldCreateCommands.add(new RightRotateCommand(new SimpleAngle(200)));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    @Test
    public void shouldCreateMoreComplexCommands() throws InvalidCommandException, InvalidNumberArgumentsException {
        String content = """
                RIPETI 4 [ FORWARD 50 BACKWARD 50 ]
                CLEARSCREEN
                RIGHT 200
                RIPETI 20 [ HOME RIGHT 40 ]
                PENUP
                SETPENSIZE 4
                SETFILLCOLOR 0 0 0
                RIPETI 1 [ SETSCREENCOLOR 255 255 255 SETPENCOLOR 100 100 100 ]
                """;
        List<Command> shouldCreateCommands = new ArrayList<>();
        List<Command> repeatCommands = new ArrayList<>();
        repeatCommands.add(new ForwardCommand(50));
        repeatCommands.add(new BackwardCommand(50));
        shouldCreateCommands.add(new RepeatCommand(4, repeatCommands));
        repeatCommands = new ArrayList<>();
        shouldCreateCommands.add(new ClearScreenCommand());
        shouldCreateCommands.add(new RightRotateCommand(new SimpleAngle(200)));
        repeatCommands.add(new HomeCommand());
        repeatCommands.add(new RightRotateCommand(new SimpleAngle(40)));
        shouldCreateCommands.add(new RepeatCommand(20, repeatCommands));
        repeatCommands = new ArrayList<>();
        shouldCreateCommands.add(new PlotCommand(false));
        shouldCreateCommands.add(new SetPenSizeCommand(4));
        shouldCreateCommands.add(new SetFillColorCommand(new RGBColor(0, 0, 0)));
        repeatCommands.add(new SetScreenColorCommand(new RGBColor(255, 255, 255)));
        repeatCommands.add(new SetPenColorCommand(new RGBColor(100, 100, 100)));
        shouldCreateCommands.add(new RepeatCommand(1, repeatCommands));
        checkNewCreatedCommands(shouldCreateCommands, parser.parse(content));
    }

    private void checkNewCreatedCommands(List<Command> shouldCreateCommands, List<Command> createdCommands) {
        assertEquals(shouldCreateCommands.size(), createdCommands.size());
        for(int i = 0; i < shouldCreateCommands.size() - 1; i++) {
            assertEquals(shouldCreateCommands.get(i).getClass(), createdCommands.get(i).getClass());
            assertEquals(shouldCreateCommands.get(i), createdCommands.get(i));
        }
    }

}
