package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.Color;

/**
 * This record represents the "SetColorScreen" command, that sets the color of the background of the drawing.
 *
 * @param color new color of the background
 */
public record SetScreenColorCommand(Color color) implements Command {

    /**
     * In the constructor is only checked whether the passed color is null or not
     *
     * @param color new color of the background
     */
    public SetScreenColorCommand {
        if (color == null)
            throw new NullPointerException("The given color must not be Null");
    }

}
