package it.unicam.cs.pa.jlogo.api.commands;

/**
 * This interface represents a generic movement command.
 */
public interface MovementCommand extends Command {

    /**
     * Returns the distance of the command
     *
     * @return the distance of the command
     */
    double distance();

}
