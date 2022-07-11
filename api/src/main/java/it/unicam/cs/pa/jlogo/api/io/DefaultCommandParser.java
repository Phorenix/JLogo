package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.RGBColor;
import it.unicam.cs.pa.jlogo.api.SimpleAngle;
import it.unicam.cs.pa.jlogo.api.commands.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultCommandParser implements CommandParser {

    @Override
    public List<Command> parse(String content) {

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
        if (command.length != 2)
            throw new IllegalArgumentException();

        return new ForwardCommand(Double.parseDouble(command[1]));
    }

    private Command backwardCommand(String[] command) {
        if (command.length != 2)
            throw new IllegalArgumentException();

        return new BackwardCommand(Double.parseDouble(command[1]));
    }

    private Command leftCommand(String[] command) {
        if (command.length != 2)
            throw new IllegalArgumentException();

        return new LeftRotateCommand(new SimpleAngle(Integer.parseInt(command[1])));
    }

    private Command rightCommand(String[] command) {
        if (command.length != 2)
            throw new IllegalArgumentException();

        return new RightRotateCommand(new SimpleAngle(Integer.parseInt(command[1])));
    }

    private Command clearScreenCommand(String[] command) {
        if (command.length != 1)
            throw new IllegalArgumentException();

        return new ClearScreenCommand();
    }

    private Command homeCommand(String[] command) {
        if (command.length != 1)
            throw new IllegalArgumentException();

        return new HomeCommand();
    }

    private Command penUpCommand(String[] command) {
        if (command.length != 1)
            throw new IllegalArgumentException();

        return new PlotCommand(false);
    }

    private Command penDownCommand(String[] command) {
        if (command.length != 1)
            throw new IllegalArgumentException();

        return new PlotCommand(true);
    }

    private Command setPenColor(String[] command) {
        if (command.length != 4)
            throw new IllegalArgumentException();

        return new SetPenColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setFillColor(String[] command) {
        if (command.length != 4)
            throw new IllegalArgumentException();

        return new SetFillColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setScreenColor(String[] command) {
        if (command.length != 4)
            throw new IllegalArgumentException();

        return new SetScreenColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setPenSize(String[] command) {
        if (command.length != 2)
            throw new IllegalArgumentException();

        return new SetPenSizeCommand(Integer.parseInt(command[1]));
    }

    private Command repeatCommand(String[] command) {
        return null;
    }

}
