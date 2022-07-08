package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.RGBColor;

public record SetFillColorCommand(RGBColor color) implements Command {

    public SetFillColorCommand {
        if(color == null)
            throw new NullPointerException("The given color must not be Null");

    }

}
