package it.unicam.cs.pa.jlogo.gui;

import it.unicam.cs.pa.jlogo.api.model.shapes.Figure;
import it.unicam.cs.pa.jlogo.api.model.shapes.Line;
import it.unicam.cs.pa.jlogo.api.model.shapes.SimpleDrawing;

/**
 * This class is used to print the log of each instruction that will be executed on the {@link it.unicam.cs.pa.jlogo.api.model.shapes.Drawing}
 *
 * @author Luca Bianchi
 */
public class GuiDrawing extends SimpleDrawing {

    @Override
    public void onAddNewLine(Line line) {
        super.onAddNewLine(line);
    }

    @Override
    public void onAddNewPolygon(Figure figure) {
        super.onAddNewPolygon(figure);
    }

    @Override
    public void onRemoveNewLine(Line line) {
        super.onRemoveNewLine(line);
    }
}
