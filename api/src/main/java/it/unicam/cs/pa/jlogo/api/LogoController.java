package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.executor.SimpleCommandExecutor;
import it.unicam.cs.pa.jlogo.api.model.GridSpace;
import it.unicam.cs.pa.jlogo.api.model.Space;
import it.unicam.cs.pa.jlogo.api.model.commands.Command;
import it.unicam.cs.pa.jlogo.api.executor.CommandExecutor;
import it.unicam.cs.pa.jlogo.api.io.*;
import it.unicam.cs.pa.jlogo.api.model.shapes.Drawing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link Controller} for a Logo Application
 *
 * @author Luca Bianchi
 */
public class LogoController implements Controller {

    private final FileReader fileReader;

    private final FileWriter fileWriter;

    private final CommandExecutor commandExecutor;

    private final Space space;

    private final Drawing drawing;

    private List<Command> commandsList;
    // Index of the next command to execute
    private int currentCommandIndex;

    /**
     * This constructor takes the drawing where will be drawn the shapes and the dimensions of it
     *
     * @param drawing drawing where will be drawn the shapes
     * @param spaceWidth width of the drawing
     * @param spaceHeight height of the drawing
     */
    public LogoController(Drawing drawing, double spaceWidth, double spaceHeight) {
        this(drawing, new GridSpace(spaceWidth, spaceHeight));
    }

    /**
     * This constructor just takes the drawing and the space
     *
     * @param drawing drawing where will be drawn the shapes
     * @param space where will operate the command executor
     */
    public LogoController(Drawing drawing, Space space) {
        this(
                new DefaultFileReader(new DefaultCommandParser()),
                new DefaultFileWriter(new DefaultShapeWriter()),
                new SimpleCommandExecutor(drawing, space),
                space,
                drawing
        );
    }

    /**
     * This is the complete constructor that takes an instance of every attribute of the controller initializing everything
     *
     * @param fileReader file reader used to read from the file
     * @param fileWriter file writer used to write into the file
     * @param commandExecutor command executor that will execute the given commands
     * @param space where will operate the command executor
     * @param drawing drawing where will be drawn the shapes
     */
    public LogoController(FileReader fileReader, FileWriter fileWriter, CommandExecutor commandExecutor, Space space, Drawing drawing) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.commandExecutor = commandExecutor;
        this.space = space;
        this.drawing = drawing;
        this.commandsList = new ArrayList<>();
        this.currentCommandIndex = 0;
    }

    @Override
    public void readCommandsFromFile(File file) throws IOException, InvalidNumberArgumentsException, InvalidCommandException {
        this.commandsList = this.fileReader.readCommandsFromFile(file);
    }

    @Override
    public void writeShapesIntoFile(File file) throws IOException {
        this.fileWriter.writeShapesIntoFile(file, this.drawing, this.space.getSpaceWidth(), this.space.getSpaceHeight());
    }

    @Override
    public void executeNextCommand() {
        if (this.commandsList.isEmpty())
            throw new IllegalStateException("A list of commands must be passed to be executed");

        this.commandExecutor.apply(this.commandsList.get(currentCommandIndex));
        this.currentCommandIndex++;
    }

    @Override
    public void executeAllCommands() {
        if (this.commandsList.isEmpty())
            throw new IllegalStateException("A list of commands must be passed to be executed");

        while (currentCommandIndex < this.commandsList.size()) {
            this.commandExecutor.apply(this.commandsList.get(currentCommandIndex));
            currentCommandIndex++;
        }
    }

    @Override
    public void clear() {
        this.drawing.clear();
        currentCommandIndex = 0;
    }

}
