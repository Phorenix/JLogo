package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.commands.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultCommandParser implements CommandParser {

    @Override
    public List<Command> parser(String content) {

        List<Command> commandsToReturn = new ArrayList<>();

        String[] commands = content.split("\n");

        for (String command : commands) {
            commandsToReturn.add(fromStringToCommand(command.split(" ")));
        }

        return commandsToReturn;
    }

    private Command fromStringToCommand(String[] command) {
        switch (command[0].toUpperCase()) {
            case "FORWARD": return forwardCommand(command);
            case "BACKWARD": return backwardCommand(command);
            case "LEFT": return leftCommand(command);
            case "RIGHT": return rightCommand(command);
            case "CLEARSCREEN": return clearScreenCommand(command);
            case "HOME": return homeCommand(command);
            case "PENUP": return penUpCommand(command);
            case "PENDOWN": return penDownCommand(command);
            case "SETPENCOLOR": return setPenColor(command);
            case "SETFILLCOLOR": return setFillColor(command);
            case "SETSCREENCOLOR": return setScreenColor(command);
            case "SETPENSIZE": return setPenSize(command);
            case "RIPETI": return repeatCommand(command);
            default: return null;
        }
    }

    private Command forwardCommand(String[] command) {

    }

    private Command backwardCommand(String[] command) {

    }

    private Command leftCommand(String[] command) {

    }

    private Command rightCommand(String[] command) {

    }

    private Command clearScreenCommand(String[] command) {

    }

    private Command homeCommand(String[] command) {

    }

    private Command penUpCommand(String[] command) {

    }

    private Command penDownCommand(String[] command) {

    }

    private Command setPenColor(String[] command) {

    }

    private Command setFillColor(String[] command) {

    }

    private Command setScreenColor(String[] command) {

    }

    private Command setPenSize(String[] command) {

    }

    private Command repeatCommand(String[] command) {

    }

}
