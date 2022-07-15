package it.unicam.cs.pa.jlogo.api.model.shapes;

import it.unicam.cs.pa.jlogo.api.model.Color;
import it.unicam.cs.pa.jlogo.api.model.Coordinate;
import it.unicam.cs.pa.jlogo.api.model.Coordinate2D;
import it.unicam.cs.pa.jlogo.api.model.RGBColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to test the behavior of the interface {@link Line}
 *
 * @author Luca Bianchi
 */
public class LineTest {

    private Color color = new RGBColor(255, 255, 255);
    private Coordinate startingPoint = new Coordinate2D(10.0, 10.0);
    private Coordinate endingPoint = new Coordinate2D(100.0, 100.0);

    @Test
    public void shouldThrowExceptionWithNullArguments() {
        assertThrows(NullPointerException.class, () -> new StraightLine(null, startingPoint, endingPoint, 1));
        assertThrows(NullPointerException.class, () -> new StraightLine(color, null, endingPoint, 1));
        assertThrows(NullPointerException.class, () -> new StraightLine(color, startingPoint, null, 1));
    }

    @Test
    public void shouldThrowExceptionWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new StraightLine(color, startingPoint, endingPoint, -1));
    }

}
