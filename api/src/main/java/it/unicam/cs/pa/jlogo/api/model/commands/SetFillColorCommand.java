package it.unicam.cs.pa.jlogo.api.model.commands;

import it.unicam.cs.pa.jlogo.api.model.Color;

/**
 * This record represents a "SetFillColor" command, that set the {@link Color} of the next new closed shapes created.
 *
 * @param color new color of the next closed shapes that will be created
 *
 * @author Luca Bianchi
 */
public record SetFillColorCommand(Color color) implements Command {

    /**
     * In the constructor is only checked whether the passed color is null or not
     *
     * @param color new color of the next closed shapes
     */
    public SetFillColorCommand {
        if(color == null)
            throw new NullPointerException("The given color must not be Null");
    }

}
