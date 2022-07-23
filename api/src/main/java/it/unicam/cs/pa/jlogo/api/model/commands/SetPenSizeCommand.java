package it.unicam.cs.pa.jlogo.api.model.commands;

/**
 * This class represents the "SetPenSize" command (the size is an int)
 *
 * @param size new size of the stroke of the next lines
 *
 * @author Luca Bianchi
 */
public record SetPenSizeCommand(int size) implements Command {

    /**
     * In the constructor is only checked if the given size is less than 1
     *
     * @param size new size of the stroke
     */
    public SetPenSizeCommand {
        if (size < 1) {
            throw new IllegalArgumentException("The size of the stroke needs to be 1 or greater");
        }
    }

}
