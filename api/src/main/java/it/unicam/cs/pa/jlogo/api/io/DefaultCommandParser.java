package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import it.unicam.cs.pa.jlogo.api.model.SimpleAngle;
import it.unicam.cs.pa.jlogo.api.model.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Default parser for a Logo application.
 *
 * @author Luca Bianchi
 *
 */
public class DefaultCommandParser implements CommandParser {

    @Override
    public List<Command> parse(String content) throws InvalidNumberArgumentsException, InvalidCommandException {

        List<Command> commandsToReturn = new ArrayList<>();

        // Split every row
        String[] commands = content.split("\n");

        // For each row, gets the respective command
        for (String command : commands) {
            commandsToReturn.add(fromStringToCommand(command.split(" ")));
        }

        return commandsToReturn;
    }

    /*
     * Utility method to return a command from an array of strings, assuming that the array has as the first string
     * the name of the command, and the next strings are the parameters of the command.
     */
    private Command fromStringToCommand(String[] command) throws InvalidNumberArgumentsException, InvalidCommandException {
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
            default: throw new InvalidCommandException(command[0]);
        }
    }

    private Command forwardCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 2)
            throw new InvalidNumberArgumentsException("1 for a new Forward Command");

        return new ForwardCommand(Double.parseDouble(command[1]));
    }

    private Command backwardCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 2)
            throw new InvalidNumberArgumentsException("1 for a new Backward Command");

        return new BackwardCommand(Double.parseDouble(command[1]));
    }

    private Command leftCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 2)
            throw new InvalidNumberArgumentsException("1 for a new Left Command");

        return new LeftRotateCommand(new SimpleAngle(Integer.parseInt(command[1])));
    }

    private Command rightCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 2)
            throw new InvalidNumberArgumentsException("1 for a new Right Command");

        return new RightRotateCommand(new SimpleAngle(Integer.parseInt(command[1])));
    }

    private Command clearScreenCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 1)
            throw new InvalidNumberArgumentsException("0 for a new Clear Screen Command");

        return new ClearScreenCommand();
    }

    private Command homeCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 1)
            throw new InvalidNumberArgumentsException("0 for a new Home Command");

        return new HomeCommand();
    }

    private Command penUpCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 1)
            throw new InvalidNumberArgumentsException("0 for a new PenUp Command");

        return new PlotCommand(false);
    }

    private Command penDownCommand(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 1)
            throw new InvalidNumberArgumentsException("0 for a new PenDown Command");

        return new PlotCommand(true);
    }

    private Command setPenColor(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 4)
            throw new InvalidNumberArgumentsException("3 for a new Set Pen Color Command");

        return new SetPenColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setFillColor(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 4)
            throw new InvalidNumberArgumentsException("3 for a new Set Fill Color Command");

        return new SetFillColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setScreenColor(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 4)
            throw new InvalidNumberArgumentsException("3 for a new Set Screen Color Command");

        return new SetScreenColorCommand(new RGBColor(
                Integer.parseInt(command[1]),
                Integer.parseInt(command[2]),
                Integer.parseInt(command[3])
        ));
    }

    private Command setPenSize(String[] command) throws InvalidNumberArgumentsException {
        if (command.length != 2)
            throw new InvalidNumberArgumentsException("1 for a new Set Pen Size Command");

        return new SetPenSizeCommand(Integer.parseInt(command[1]));
    }

    /*
     * In this utility method the parser, once checked taken the number of repetitions, it tries to parse the next commands
     */
    private Command repeatCommand(String[] command) throws InvalidNumberArgumentsException, InvalidCommandException {
        int num = Integer.parseInt(command[1]);
        List<Command> commandsRepeat = new ArrayList<>();

        if (!Objects.equals(command[2], "[") || !Objects.equals(command[command.length - 1], "]"))
            throw new InvalidCommandException("Repeat Command must have [ ] to specify the commands to repeat");

        for (int i = 3; i <= command.length - 2;) {
            List<String> newCommand = new ArrayList<>();
            if (isWordCommand(command[i])) {
                newCommand.add(command[i++]);
                while (!isWordCommand(command[i]) && i < command.length - 1) {
                    newCommand.add(command[i++]);
                }
            }
            commandsRepeat.add(fromStringToCommand(newCommand.toArray(new String[0])));
        }

        return new RepeatCommand(num, commandsRepeat);
    }

    /*
     * This utility method check if the given string is a word or not.
     */
    private boolean isWordCommand(String string) {
        // return string.charAt(0) == 'F' || string.charAt(0) == 'B' || string.charAt(0) == 'L' || string.charAt(0) == 'R' || string.charAt(0) == 'C' || string.charAt(0) == 'H' || string.charAt(0) == 'P' || string.charAt(0) == 'S';
        return string.matches("^[a-zA-Z]*$");
    }

}
