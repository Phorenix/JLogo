package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.commands.Command;

public interface CommandExecutor {

    void apply(Command command);

}
