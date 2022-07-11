package it.unicam.cs.pa.jlogo.api.commands;

/**
 * This class represents a "Backward" movement (and implements the interface Movement Command because is basically
 * a movement).
 *
 * @param distance how much the cursor needs to go back
 */
public record BackwardCommand(double distance) implements MovementCommand {

    /**
     * In the constructor is only checked if the given distance to the command is positive
     *
     * @param distance given distance to initialize the new command
     */
    public BackwardCommand {
        if (distance < 0)
            throw new IllegalArgumentException("The given distance must be positive");
    }

}
