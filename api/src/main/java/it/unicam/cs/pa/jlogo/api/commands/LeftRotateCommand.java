package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.Angle;

public record LeftRotateCommand(Angle angle) implements RotateCommand {

    public LeftRotateCommand {
        if (angle == null)
            throw new NullPointerException("The given angle must not be Null");
    }

}
