package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.*;
import it.unicam.cs.pa.jlogo.api.shapes.Drawing;
import it.unicam.cs.pa.jlogo.api.commands.*;

import java.util.Objects;

public class SimpleCommandExecutor implements CommandExecutor {

    private final Drawing drawing;

    private final Space space;

    public SimpleCommandExecutor(Drawing drawing, Space space) {
        this.drawing = Objects.requireNonNull(drawing);
        this.space = Objects.requireNonNull(space);
    }

    public SimpleCommandExecutor(Drawing drawing) {
        this(drawing, new GridSpace(drawing.getWidth(), drawing.getHeight()));
    }

    @Override
    public void apply(Command command) {
        if (command instanceof MovementCommand movementCommand) applyMovementCommand(movementCommand);
        else if (command instanceof RotateCommand rotateCommand) applyRotateCommand(rotateCommand);
        else if (command instanceof ClearScreenCommand clearScreenCommand) applyClearScreenCommand(clearScreenCommand);
        else if (command instanceof HomeCommand homeCommand) applyHomeCommand(homeCommand);
        else if (command instanceof PlotCommand plotCommand) applyPlotCommand(plotCommand);
        else if (command instanceof SetPenColorCommand setPenColorCommand) applySetPenColorCommand(setPenColorCommand);
        else if (command instanceof SetFillColorCommand setFillColorCommand)
            applySetFillColorCommand(setFillColorCommand);
        else if (command instanceof SetScreenColorCommand setScreenColorCommand)
            applySetScreenColorCommand(setScreenColorCommand);
        else if (command instanceof SetPenSizeCommand setPenSizeCommand) applySetPenSizeCommand(setPenSizeCommand);
        else if (command instanceof RepeatCommand repeatCommand) applyRepeatCommand(repeatCommand);
        else throw new IllegalArgumentException();
    }

    private void applyMovementCommand(MovementCommand movementCommand) {
        if (movementCommand instanceof ForwardCommand forwardCommand) applyForwardCommand(forwardCommand);
        else if (movementCommand instanceof BackwardCommand backwardCommand) applyBackwardCommand(backwardCommand);
        else throw new IllegalArgumentException();
    }

    private void applyForwardCommand(ForwardCommand forwardCommand) {
        // TODO this part also needs to create a new Line
        this.space.moveCursor(calculateNewCoordinate(this.space.getCursorPosition(),
                this.space.getCursorDirection(), forwardCommand.distance()));
    }

    private void applyBackwardCommand(BackwardCommand backwardCommand) {
        // TODO this part also needs to create a new Line
        this.space.moveCursor(calculateNewCoordinate(this.space.getCursorPosition(),
                this.space.getCursorDirection().getComplementaryAngle(), backwardCommand.distance()));
    }

    private Coordinate calculateNewCoordinate(Coordinate currentCursorPosition, Angle currentAngle, double distance) {
        return new Coordinate(currentCursorPosition.x() + (distance * Math.cos(currentAngle.getAngle())),
                currentCursorPosition.y() + (distance * Math.sin(currentAngle.getAngle())));
    }

    private void applyRotateCommand(RotateCommand rotateCommand) {
        if (rotateCommand instanceof LeftRotateCommand leftRotateCommand) applyLeftRotateCommand(leftRotateCommand);
        else if (rotateCommand instanceof RightRotateCommand rightRotateCommand) applyRightRotateCommand(rightRotateCommand);
        else throw new IllegalArgumentException();
    }

    private void applyRightRotateCommand(RightRotateCommand rightRotateCommand) {
        this.space.getCursorDirection().rightRotation(rightRotateCommand.angle());
    }

    private void applyLeftRotateCommand(LeftRotateCommand leftRotateCommand) {
        this.space.getCursorDirection().leftRotation(leftRotateCommand.angle());
    }

    private void applyClearScreenCommand(ClearScreenCommand clearScreenCommand) {
        // TODO does it need to clear everything?
        this.drawing.clear();
    }

    private void applyHomeCommand(HomeCommand homeCommand) {
        this.space.moveCursorToHome();
    }

    private void applyPlotCommand(PlotCommand plotCommand) {
        this.space.getCursor().setPlot(plotCommand.plot());
    }

    private void applySetPenColorCommand(SetPenColorCommand setPenColorCommand) {
        this.space.getCursor().setPenColor(setPenColorCommand.color());
    }

    private void applySetFillColorCommand(SetFillColorCommand setFillColorCommand) {
        this.space.getCursor().setFillColor(setFillColorCommand.color());
    }

    private void applySetScreenColorCommand(SetScreenColorCommand setScreenColorCommand) {
        this.drawing.setBackgroundColor(setScreenColorCommand.color());
    }

    private void applySetPenSizeCommand(SetPenSizeCommand setPenSizeCommand) {
        // TODO who has the size?
    }

    private void applyRepeatCommand(RepeatCommand repeatCommand) {

    }
}
