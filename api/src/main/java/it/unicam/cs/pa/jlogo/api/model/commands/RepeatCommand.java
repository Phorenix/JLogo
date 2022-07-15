package it.unicam.cs.pa.jlogo.api.model.commands;

import java.util.List;

/**
 * This record represents the "Ripeti" command, that repeat the given <code>commands</code> for <code>n</code> times.
 *
 * @param n number of times that the command needs to be repeated
 * @param commands list of commands to execute
 *
 * @author Luca Bianchi
 */
public record RepeatCommand(int n, List<Command> commands) implements Command {

    /**
     * In the constructor is checked if the number of times to execute the given commands is less than 0, and
     * if the given commands are null.
     *
     * @param n number of times to execute the command
     * @param commands commands to execute
     */
    public RepeatCommand {
        if (n < 0)
            throw new IllegalArgumentException("The number of repetitions needs to be positive");

        if (commands == null)
            throw new NullPointerException("The given commands must not be Null");
    }

}
