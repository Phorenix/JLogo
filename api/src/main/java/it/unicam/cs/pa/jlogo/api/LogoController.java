package it.unicam.cs.pa.jlogo.api;

import it.unicam.cs.pa.jlogo.api.commands.Command;
import it.unicam.cs.pa.jlogo.api.executor.CommandExecutor;
import it.unicam.cs.pa.jlogo.api.executor.SimpleCommandExecutor;
import it.unicam.cs.pa.jlogo.api.io.*;
import it.unicam.cs.pa.jlogo.api.shapes.Drawing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogoController {

    // TODO probably needs both a space and a drawing

    private final FileReader fileReader;

    private final FileWriter fileWriter;

    private final CommandExecutor commandExecutor;

    private final Space space;

    private Drawing drawing;

    private List<Command> commandsList;
    private int currentCommandIndex;

    public static LogoController getLogoController(double spaceWidth, double spaceHeight) {
        return new LogoController(
                new DefaultFileReader(new DefaultCommandParser()),
                new DefaultFileWriter(new DefaultShapeWriter()),
                new SimpleCommandExecutor(new GridSpace(spaceWidth, spaceHeight))
        );
    }

    public LogoController(FileReader fileReader, FileWriter fileWriter, CommandExecutor commandExecutor) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.commandExecutor = commandExecutor;
        this.space = new GridSpace(0, 0);
        this.commandsList = new ArrayList<>();
        this.currentCommandIndex = 0;
    }

    public void readCommandsFromFile(File file) throws IOException {
        this.commandsList = this.fileReader.readCommandsFromFile(file);
    }

    public void writeShapesIntoFile(File file) throws IOException {
        this.fileWriter.writeShapesIntoFile(file, this.drawing.getFigures());
    }

    public void executeNextCommand() {
        this.commandExecutor.apply(this.commandsList.get(currentCommandIndex));
        this.currentCommandIndex++;
    }

}
