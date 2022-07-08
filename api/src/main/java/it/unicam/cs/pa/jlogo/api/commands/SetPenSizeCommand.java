package it.unicam.cs.pa.jlogo.api.commands;

public record SetPenSizeCommand(int size) implements Command {

    public SetPenSizeCommand {
        if (size < 1) {
            throw new IllegalArgumentException("The size of the stroke needs to be 1 or greater");
        }
    }

}
