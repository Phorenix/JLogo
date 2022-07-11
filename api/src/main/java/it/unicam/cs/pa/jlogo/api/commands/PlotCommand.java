package it.unicam.cs.pa.jlogo.api.commands;

/**
 * This record represents a "PenDown" OR "PenUp" command.
 * To distinguish which one it is, it is used the boolean plot
 *
 * @param plot if true, then is basically a "PenDown" command because it needs to print a line.
 *             otherwise is a "PenUp" command
 */
public record PlotCommand (boolean plot) implements Command {
}
