package it.unicam.cs.pa.jlogo.api.model.commands;

import it.unicam.cs.pa.jlogo.api.model.Angle;

/**
 * This class represents a "Left" command (so it implements the interface {@link RotateCommand}).
 *
 * @param angle the angle of the counterclockwise rotation
 *
 * @author Luca Bianchi
 */
public record LeftRotateCommand(Angle angle) implements RotateCommand {

    /**
     * In the constructor is only checked if the given in angle is null
     *
     * @param angle initialization of the angle of the command itself
     */
    public LeftRotateCommand {
        if (angle == null)
            throw new NullPointerException("The given angle must not be Null");
    }

}
