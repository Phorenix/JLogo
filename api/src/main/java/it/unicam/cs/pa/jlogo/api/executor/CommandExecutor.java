package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.model.commands.Command;

/**
 * This interface has the responsibility to represent an "executor" of commands.
 * Basically just gets a new command then executes it, changing the state of the associated objects.
 *
 * @author Luca Bianchi
 */
public interface CommandExecutor {

    /**
     * This method executes the given command
     *
     * @param command command to execute
     */
    void apply(Command command);

}
