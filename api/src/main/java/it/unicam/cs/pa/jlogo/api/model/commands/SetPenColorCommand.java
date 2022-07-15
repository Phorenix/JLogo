package it.unicam.cs.pa.jlogo.api.model.commands;

import it.unicam.cs.pa.jlogo.api.model.Color;

/**
 * This record represents a "SetPenColor" command, that set the color of the next new lines that will be created.
 *
 * @param color new color of the next lines
 *
 * @author Luca Bianchi
 */
public record SetPenColorCommand(Color color) implements Command {

    /**
     * In the constructor is only checked whether the passed color is null or not
     *
     * @param color new color of the next lines
     */
    public SetPenColorCommand {
        if(color == null)
            throw new NullPointerException("The given color must not be Null");

    }

}
