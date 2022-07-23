package it.unicam.cs.pa.jlogo.api.executor;

import it.unicam.cs.pa.jlogo.api.model.Angle;
import it.unicam.cs.pa.jlogo.api.model.Coordinate;
import it.unicam.cs.pa.jlogo.api.model.Coordinate2D;
import it.unicam.cs.pa.jlogo.api.model.Space;
import it.unicam.cs.pa.jlogo.api.model.shapes.Drawing;
import it.unicam.cs.pa.jlogo.api.model.commands.*;
import it.unicam.cs.pa.jlogo.api.model.shapes.SimpleDrawing;
import it.unicam.cs.pa.jlogo.api.model.shapes.StraightLine;

import java.util.Objects;

/**
 * Default implementation of a {@link CommandExecutor}
 *
 * @author Luca Bianchi
 */
public class SimpleCommandExecutor implements CommandExecutor {

    // Associated drawing, where the executor will execute the commands
    private final Drawing drawing;

    // Associated space, where the executor will execute the commands
    private final Space space;

    public SimpleCommandExecutor(Drawing drawing, Space space) {
        this.drawing = Objects.requireNonNull(drawing);
        this.space = Objects.requireNonNull(space);
    }

    /**
     * This constructor calls the default one, passing a new default drawing and the given space
     *
     * @param space given space to the executor
     */
    public SimpleCommandExecutor(Space space) {
        this(new SimpleDrawing(), space);
    }

    @Override
    public void apply(Command command) {
        // Check every possible instance of the given command, and based on which one it is, calls the related utility method.
        if (command instanceof MovementCommand movementCommand) applyMovementCommand(movementCommand);
        else if (command instanceof RotateCommand rotateCommand) applyRotateCommand(rotateCommand);
        else if (command instanceof ClearScreenCommand) applyClearScreenCommand();
        else if (command instanceof HomeCommand) applyHomeCommand();
        else if (command instanceof PlotCommand plotCommand) applyPlotCommand(plotCommand);
        else if (command instanceof SetPenColorCommand setPenColorCommand) applySetPenColorCommand(setPenColorCommand);
        else if (command instanceof SetFillColorCommand setFillColorCommand) applySetFillColorCommand(setFillColorCommand);
        else if (command instanceof SetScreenColorCommand setScreenColorCommand) applySetScreenColorCommand(setScreenColorCommand);
        else if (command instanceof SetPenSizeCommand setPenSizeCommand) applySetPenSizeCommand(setPenSizeCommand);
        else if (command instanceof RepeatCommand repeatCommand) applyRepeatCommand(repeatCommand);
        else throw new IllegalArgumentException("Passed Command doesn't exist");
    }

    /**
     * Utility method that also checks the instance of given generic movement command passed
     *
     * @param movementCommand generic movement command to execute
     */
    private void applyMovementCommand(MovementCommand movementCommand) {
        if (movementCommand instanceof ForwardCommand)
            computeMovementCommand(this.space.getCursorDirection(), movementCommand.distance());
        else if (movementCommand instanceof BackwardCommand)
            // If it's a BackwardCommand it passes to the method computeMovementCommand() the complementary angle
            computeMovementCommand(this.space.getCursorDirection().getComplementaryAngle(), movementCommand.distance());
        else throw new IllegalArgumentException("This movement command doesn't exist");
    }

    /**
     * Utility method that apply the generic movement to the cursor, moving it in the space.
     * This method also calls the method of the drawing to add the new line that has been drawn by the cursor if it is
     * plotting
     *
     * @param angle    direction of the movement
     * @param distance of the movement
     */
    private void computeMovementCommand(Angle angle, double distance) {
        Coordinate startingPoint = this.space.getCursorPosition();
        Coordinate correctEndingPoint = calculateNewCoordinate(startingPoint, angle, distance);

        this.space.moveCursor(correctEndingPoint);

        if (this.space.getCursor().isPlotting())
            this.drawing.addNewLine(
                    new StraightLine(this.space.getCursor().getLineColor(), startingPoint, correctEndingPoint, this.space.getCursor().getPenSize()),
                    this.space.getCursor().getFillColor()
            );
    }

    /**
     * Utility method that calculates the respective coordinate given the current position of the cursor, the direction
     * of the movement and the distance of the movement
     *
     * @param currentCursorPosition current position of the cursor in the space
     * @param currentAngle          direction of the movement
     * @param distance              of the movement
     * @return the ending point of the relative movement command
     */
    private Coordinate calculateNewCoordinate(Coordinate currentCursorPosition, Angle currentAngle, double distance) {
        double coordinateX = currentCursorPosition.x() + (distance * Math.cos(Math.toRadians(currentAngle.getAngle())));
        double coordinateY = currentCursorPosition.y() + (distance * Math.sin(Math.toRadians(currentAngle.getAngle())));

        return clipCoordinateValues(coordinateX, coordinateY);
    }

    /**
     * Utility method that based on the space's dimensions and the given x and y of the coordinate, returns a new
     * coordinate that is "clipped", meaning that doesn't go beyond its range.
     *
     * @param coordinateX x of the coordinate to clip
     * @param coordinateY y of the coordinate to clip
     * @return the clipped coordinate
     */
    private Coordinate clipCoordinateValues(double coordinateX, double coordinateY) {
        return new Coordinate2D(
                Math.max(Math.min(coordinateX, this.space.getSpaceWidth()), 0),
                Math.max(Math.min(coordinateY, this.space.getSpaceHeight()), 0)
        );
    }

    /**
     * Utility method that also checks the instance of given generic rotation command passed
     *
     * @param rotateCommand generic rotation command
     */
    private void applyRotateCommand(RotateCommand rotateCommand) {
        if (rotateCommand instanceof LeftRotateCommand leftRotateCommand) applyLeftRotateCommand(leftRotateCommand);
        else if (rotateCommand instanceof RightRotateCommand rightRotateCommand)
            applyRightRotateCommand(rightRotateCommand);
        else throw new IllegalArgumentException();
    }

    /**
     * Utility method that rotates the cursor in the space of the given angle in the RightRotateCommand passed
     *
     * @param rightRotateCommand right rotation command passed
     */
    private void applyRightRotateCommand(RightRotateCommand rightRotateCommand) {
        this.space.getCursorDirection().rightRotation(rightRotateCommand.angle());
    }

    /**
     * Utility method that rotates the cursor in the space of the given angle in the LeftRotateCommand passed
     *
     * @param leftRotateCommand left rotation command passed
     */
    private void applyLeftRotateCommand(LeftRotateCommand leftRotateCommand) {
        this.space.getCursorDirection().leftRotation(leftRotateCommand.angle());
    }

    /**
     * Utility method to execute the Clear Screen Command passed
     */
    private void applyClearScreenCommand() {
        this.drawing.clear();
    }

    /**
     * Utility method to execute the Home Command
     * (If the cursor is plotting then it will also write a new Line)
     */
    private void applyHomeCommand() {
        if (this.space.getCursor().isPlotting())
            this.drawing.addNewLine(
                    new StraightLine(this.space.getCursor().getLineColor(), this.space.getCursorPosition(),
                            this.space.getHome(), this.space.getCursor().getPenSize()), this.space.getCursor().getFillColor()
            );

        this.space.moveCursor(this.space.getHome());
    }

    /**
     * Utility method that executes an instance of a plotCommand, and so just calls the setPlot() method of the cursor in
     * the space passing the boolean plot in the command.
     *
     * @param plotCommand plot command to execute
     */
    private void applyPlotCommand(PlotCommand plotCommand) {
        this.space.getCursor().setPlot(plotCommand.plot());
    }

    /**
     * Utility method to executes a setPenColorCommand, calling the method setPenColor() of the cursor in the space
     * using the color given in the command.
     *
     * @param setPenColorCommand set pen color command to execute
     */
    private void applySetPenColorCommand(SetPenColorCommand setPenColorCommand) {
        this.space.getCursor().setPenColor(setPenColorCommand.color());
    }

    /**
     * Utility method to execute a setFillColorCommand, calling the method setFillColor() of the cursor in the space and
     * using the color in the given command.
     *
     * @param setFillColorCommand set fill color command to execute
     */
    private void applySetFillColorCommand(SetFillColorCommand setFillColorCommand) {
        this.space.getCursor().setFillColor(setFillColorCommand.color());
    }

    /**
     * Utility method to execute a setScreenColorCommand, calling the method setBackgroundColor() of the
     * drawing associated in the executor using the color in the given command.
     *
     * @param setScreenColorCommand set screen color command to execute
     */
    private void applySetScreenColorCommand(SetScreenColorCommand setScreenColorCommand) {
        this.drawing.setBackgroundColor(setScreenColorCommand.color());
    }

    /**
     * This method set the pen size to the given size passed with the set pen size command
     *
     * @param setPenSizeCommand set pen size command that has the new size of the pen in it
     */
    private void applySetPenSizeCommand(SetPenSizeCommand setPenSizeCommand) {
        this.space.getCursor().setPenSize(setPenSizeCommand.size());
    }

    /**
     * This method executes for n times all the commands written in the repeatCommand, just by iterating for n times
     * calling the method apply() for each command in the list of the given repeat command
     *
     * @param repeatCommand repeat command to execute (that has a list of commands and an integer for the number
     *                      of repetitions)
     */
    private void applyRepeatCommand(RepeatCommand repeatCommand) {
        for (int i = 0; i < repeatCommand.n(); i++) {
            for (Command command : repeatCommand.commands())
                this.apply(command);
        }
    }
}
