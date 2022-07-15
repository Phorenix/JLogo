package it.unicam.cs.pa.jlogo.api.model.commands;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to do a simple test on each class implementing the interface {@link Command} checking that they return
 * the expected errors
 *
 * @author Luca Bianchi
 */
public class CommandTest {

    @Test
    public void shouldThrowExceptionCreateMovementCommand() {
        assertThrows(IllegalArgumentException.class, () -> new BackwardCommand(-1));
        assertThrows(IllegalArgumentException.class, () -> new ForwardCommand(-1));
    }

    @Test
    public void shouldThrowExceptionCreateRotateCommand() {
        assertThrows(NullPointerException.class, () -> new LeftRotateCommand(null));
        assertThrows(NullPointerException.class, () -> new RightRotateCommand(null));
    }

    @Test
    public void shouldThrowExceptionCreateRepeatCommand() {
        List<Command> repeatCommands = new ArrayList<>();
        repeatCommands.add(new HomeCommand());
        assertThrows(NullPointerException.class, () -> new RepeatCommand(4, null));
        assertThrows(IllegalArgumentException.class, () -> new RepeatCommand(-1, repeatCommands));
    }

    @Test
    public void shouldThrowExceptionCreateSetFillColorCommand() {
        assertThrows(NullPointerException.class, () -> new SetFillColorCommand(null));
    }

    @Test
    public void shouldThrowExceptionCreateSetPenColorCommand() {
        assertThrows(NullPointerException.class, () -> new SetPenColorCommand(null));
    }

    @Test
    public void shouldThrowExceptionCreateSetScreenColorCommand() {
        assertThrows(NullPointerException.class, () -> new SetScreenColorCommand(null));
    }

    @Test
    public void shouldThrowExceptionCreateSetPenSizeCommand() {
        assertThrows(IllegalArgumentException.class, () -> new SetPenSizeCommand(-1));
    }
}
