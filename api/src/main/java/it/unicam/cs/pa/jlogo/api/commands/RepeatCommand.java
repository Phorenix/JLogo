package it.unicam.cs.pa.jlogo.api.commands;

public record RepeatCommand(int n, Command command) implements Command {

    public RepeatCommand {
        if (n < 0)
            throw new IllegalArgumentException("The number of repetitions needs to be positive");

        if (command == null)
            throw new NullPointerException("The given command must not be Null");
    }

}
