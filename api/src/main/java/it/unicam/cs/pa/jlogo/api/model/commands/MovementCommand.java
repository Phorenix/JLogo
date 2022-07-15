package it.unicam.cs.pa.jlogo.api.model.commands;

/**
 * This interface represents a generic movement command.
 *
 * @author Luca Bianchi
 */
public interface MovementCommand extends Command {

    /**
     * Returns the distance of the command
     *
     * @return the distance of the command
     */
    double distance();

}
