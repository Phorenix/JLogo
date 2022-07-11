package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.commands.Command;

import java.util.List;

public interface CommandParser {

    List<Command> parse(String content);

}
