package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.RGBColor;

public record SetPenColorCommand(RGBColor color) implements Command {

    public SetPenColorCommand {
        if(color == null)
            throw new NullPointerException("The given color must not be Null");

    }

}
