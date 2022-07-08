package it.unicam.cs.pa.jlogo.api.commands;

public record BackwardCommand(double distance) implements MovementCommand {

    public BackwardCommand {
        if (distance < 0)
            throw new IllegalArgumentException("The given distance must be positive");
    }

}
