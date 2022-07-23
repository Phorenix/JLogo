package it.unicam.cs.pa.jlogo.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class to check the usage of the interface {@link Cursor}
 *
 * @author Luca Bianchi
 */
public class CursorTest {

    @Test
    public void shouldCreateNewDefaultCursor() {
        Cursor cursor = new SimpleCursor();
        // Check color of the line (should be black)
        assertEquals(new RGBColor(0, 0, 0), cursor.getLineColor());
        assertEquals(1, cursor.getPenSize());
        // Check color of the closed are (should be white)
        assertEquals(new RGBColor(255, 255, 255), cursor.getFillColor());
        assertFalse(cursor.isPlotting());
    }

    @Test
    public void shouldSetPenSizeTo4() {
        Cursor cursor = new SimpleCursor();
        cursor.setPenSize(4);
        assertEquals(4, cursor.getPenSize());
    }

    @Test
    public void shouldSetFillColorToRed() {
        Cursor cursor = new SimpleCursor();
        cursor.setFillColor(new RGBColor(255, 0, 0));
        assertEquals(new RGBColor(255, 0, 0), cursor.getFillColor());
    }

    @Test
    public void shouldSetPenColorToGreen() {
        Cursor cursor = new SimpleCursor();
        cursor.setPenColor(new RGBColor(0, 128, 0));
        assertEquals(new RGBColor(0, 128, 0), cursor.getLineColor());
    }

}
