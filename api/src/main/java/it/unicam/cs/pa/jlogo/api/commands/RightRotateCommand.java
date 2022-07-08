package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.Angle;

public record RightRotateCommand(Angle angle) implements RotateCommand {

    public RightRotateCommand {
        if (angle == null)
            throw new NullPointerException("The given angle must not be Null");
    }

}
