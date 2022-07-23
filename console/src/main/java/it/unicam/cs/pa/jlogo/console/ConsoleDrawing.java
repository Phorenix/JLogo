package it.unicam.cs.pa.jlogo.console;

import it.unicam.cs.pa.jlogo.api.model.shapes.Figure;
import it.unicam.cs.pa.jlogo.api.model.shapes.Line;
import it.unicam.cs.pa.jlogo.api.model.shapes.SimpleDrawing;

/**
 * This class extends the already created {@link it.unicam.cs.pa.jlogo.api.model.shapes.SimpleDrawing},
 * but implementing the default methods to log the result of the instructions on the drawing.
 *
 * @author Luca Bianchi
 */
public class ConsoleDrawing extends SimpleDrawing {

    @Override
    public void onAddNewLine(Line line) {
        System.out.println("New line drawn: Starting point:(" + line.startingPoint().x() + "," + line.startingPoint().y() + "), " +
                "Ending point:(" + line.endingPoint().x() + "," + line.endingPoint().y() + "), Color:(R:" + line.color().red() + ", G:" +
                line.color().green() + ", B:" + line.color().blue() + "), Size: " + line.size());
    }

    @Override
    public void onAddNewPolygon(Figure figure) {
        System.out.println("New added Polygon: Number Of Segments: " + figure.getNumberOfSegments() + ", Filling Color:(R:" +
                figure.color().red() + ", G:" + figure.color().green() + ", B:" + figure.color().blue() + ")");
    }

    @Override
    public void onRemoveNewLine(Line line) {
        System.out.println("Line removed: Starting point:(" + line.startingPoint().x() + "," + line.startingPoint().y() + "), " +
                "Ending point:(" + line.endingPoint().x() + "," + line.endingPoint().y() + ")");
    }
}
