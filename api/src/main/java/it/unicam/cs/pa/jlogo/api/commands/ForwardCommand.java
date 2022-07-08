package it.unicam.cs.pa.jlogo.api.commands;

public record ForwardCommand (double distance) implements MovementCommand {

    public ForwardCommand {
        if (distance < 0)
            throw new IllegalArgumentException("The given distance must be positive");
    }

}
