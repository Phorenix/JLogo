package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import it.unicam.cs.pa.jlogo.api.model.SimpleAngle;
import it.unicam.cs.pa.jlogo.api.model.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Default {@link CommandParser} for a Logo application.
 *
 * @author Luca Bianchi
 */
public class DefaultCommandParser implements CommandParser {

    @Override
    public List<Command> parse(String content) throws InvalidNumberArgumentsException, InvalidCommandException {

        List<Command> commandsToReturn = new ArrayList<>();

        // Split every row by using \r\n or \n
        String[] commands = content.split("\r\n|\n");

        // For each row, gets the respective command
        for (String command : commands) {
            // Splits using " " (space) or
            commandsToReturn.add(fromStringToCommand(command.split(" |((?<=\\[)|(?=\\[))|((?<=])|(?=]))")));
        }

        return commandsToReturn;
    }

    /*
     * Utility method used to return a command from an array of strings, assuming that the array has as the first string
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
     * In this utility method the parser, once taken the number of repetitions, it tries to parse the next commands that
     * will be part of the repeat command.
     */
    private Command repeatCommand(String[] command) throws InvalidNumberArgumentsException, InvalidCommandException {
        List<String> trimmedCommand = trimRepeatCommand(command);
        int num = Integer.parseInt(trimmedCommand.get(1));
        List<Command> listOfRepeatCommands = new ArrayList<>();

        if (!Objects.equals(trimmedCommand.get(2), "[") || !Objects.equals(trimmedCommand.get(trimmedCommand.size() - 1), "]"))
            throw new InvalidCommandException("Repeat Command must have [ ] to specify the commands to repeat");

        for (int i = 3; i <= trimmedCommand.size() - 2; ) {
            List<String> newCommand = new ArrayList<>();
            i += nextCommandOfTheListForRepeatCommand(trimmedCommand, listOfRepeatCommands, newCommand, i);
            if (listOfRepeatCommands.isEmpty() || !(listOfRepeatCommands.get(listOfRepeatCommands.size() - 1) instanceof RepeatCommand))
                // Case in which the last command wasn't a new return command, so whatever command it is, it needs to be added
                listOfRepeatCommands.add(fromStringToCommand(newCommand.toArray(new String[0])));
        }

        return new RepeatCommand(num, listOfRepeatCommands);
    }

    /*
     * This utility method checks if the given string is a word or not.
     */
    private boolean isWordCommand(String string) {
        return string.matches("^[a-zA-Z]*$");
    }

    /*
     * This method returns an array list from an array of strings of only those strings that have a trimmed length more
     * than 0
     */
    private List<String> trimRepeatCommand(String[] command) {
        List<String> trimmedCommand = new ArrayList<>();

        for (String s : command) {
            if (s.trim().length() > 0) trimmedCommand.add(s);
        }

        return trimmedCommand;
    }

    /**
     * This utility method search and creates for the next command that will be part of the list of commands of the
     * requested repeat command.
     * It will start to search for a new command in the list command from the int index and so on.
     * It returns the number of positions that the method has consumed of the command list.
     *
     * @param command list of strings containing the commands (and where will be searched the next command)
     * @param listOfRepeatCommands ending list of commands that will be used to create the new repeat command
     * @param newCommandForList command (represented as a list of strings) where will be put the new command
     * @param index int from which positions start to search in the command argument
     * @return the number of positions that the method has consumed of the command list
     * @throws InvalidCommandException In case the command passed to the parser is unknown
     * @throws InvalidNumberArgumentsException In case the command passed to the parser has an incorrect number of arguments
     */
    private int nextCommandOfTheListForRepeatCommand(List<String> command, List<Command> listOfRepeatCommands, List<String> newCommandForList, int index) throws InvalidCommandException, InvalidNumberArgumentsException {
        int newIndex = index;

        if (isWordCommand(command.get(newIndex))) {
            if (command.get(newIndex).equalsIgnoreCase("ripeti")) {
                int nextBracket = searchNextBracket(command.subList(newIndex, command.size()));
                listOfRepeatCommands.add(repeatCommand(command.subList(newIndex, newIndex + nextBracket).toArray(new String[0])));
                newIndex += nextBracket;
                return newIndex - index;
            } else {
                newCommandForList.add(command.get(newIndex++));
                while (!isWordCommand(command.get(newIndex)) && newIndex < command.size() - 1) {
                    newCommandForList.add(command.get(newIndex++));
                }
            }
        }

        return newIndex - index;
    }

    /*
     * This utility method is invoked when a new repeat command is found inside another repeat command, so it returns
     * the index of the second-last closing square bracket "]" + 1.
     */
    private int searchNextBracket(List<String> command) throws InvalidCommandException {
        for (int i = command.size() - 2; i > 0; i--) {
            if (command.get(i).equals("]")) return i + 1;
        }

        throw new InvalidCommandException("Error on multiple repeat command");
    }

}
