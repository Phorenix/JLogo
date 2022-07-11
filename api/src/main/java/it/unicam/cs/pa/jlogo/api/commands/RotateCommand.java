package it.unicam.cs.pa.jlogo.api.commands;

import it.unicam.cs.pa.jlogo.api.Angle;

/**
 * This interface has the responsibility to represent a generic rotation command.
 */
public interface RotateCommand extends Command {

    // TODO Returns Angle?

    /**
     * Returns the angle of the rotation command
     *
     * @return the angle of the rotation command
     */
    Angle angle();

}
