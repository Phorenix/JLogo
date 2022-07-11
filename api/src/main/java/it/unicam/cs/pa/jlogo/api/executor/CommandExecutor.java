package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.commands.Command;

/**
 * This interface has the responsibility to represent an "executor" of commands.
 * Basically just gets a new command then execute it, changing the state of the associated objects.
 */
public interface CommandExecutor {

    /**
     * This method execute the given command
     *
     * @param command command to execute
     */
    void apply(Command command);

}
