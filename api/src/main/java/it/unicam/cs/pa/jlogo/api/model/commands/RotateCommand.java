package it.unicam.cs.pa.jlogo.api.model.commands;

import it.unicam.cs.pa.jlogo.api.model.Angle;

/**
 * This interface has the responsibility to represent a generic rotation command.
 *
 * @author Luca Bianchi
 */
public interface RotateCommand extends Command {

    /**
     * Returns the angle of the rotation command
     *
     * @return the angle of the rotation command
     */
    Angle angle();

}
