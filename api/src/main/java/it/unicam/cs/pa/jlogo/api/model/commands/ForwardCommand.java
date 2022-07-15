package it.unicam.cs.pa.jlogo.api.model.commands;

/**
 * This class represents a "Forward" movement (and implements the interface Movement Command because is basically
 * a movement).
 *
 * @param distance how much the cursor needs to go forward
 *
 * @author Luca Bianchi
 */
public record ForwardCommand (double distance) implements MovementCommand {

    /**
     * In the constructor is only checked if the given distance is positive
     *
     * @param distance given distance to initialize the new command
     */
    public ForwardCommand {
        if (distance < 0)
            throw new IllegalArgumentException("The given distance must be positive");
    }

}
