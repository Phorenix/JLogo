package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.Angle;

/**
 * This class represents a "Right" command (so it implements the interface RotateCommand).
 *
 * @param angle the angle of the clockwise rotation
 */
public record RightRotateCommand(Angle angle) implements RotateCommand {

    /**
     * In the constructor is only checked if the given in angle is null
     *
     * @param angle initialization of the angle of the command itself
     */
    public RightRotateCommand {
        if (angle == null)
            throw new NullPointerException("The given angle must not be Null");
    }

}
