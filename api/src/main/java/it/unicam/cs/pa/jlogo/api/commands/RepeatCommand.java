package it.unicam.cs.pa.jlogo.api.commands;

/**
 * This record represents the "Ripeti" command, that repeat the given <code>command</code> for <code>n</code> times.
 *
 * @param n number of times that the command needs to be repeated
 * @param command command to execute
 */
public record RepeatCommand(int n, Command command) implements Command {

    /**
     * In the constructor is checked if the number of times to execute the given command is less than 0, and
     * if the given command is null.
     *
     * @param n number of times to execute the command
     * @param command command to execute
     */
    public RepeatCommand {
        if (n < 0)
            throw new IllegalArgumentException("The number of repetitions needs to be positive");

        if (command == null)
            throw new NullPointerException("The given command must not be Null");
    }

}
