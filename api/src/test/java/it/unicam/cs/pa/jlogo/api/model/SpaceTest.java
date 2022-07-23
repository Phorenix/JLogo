package it.unicam.cs.pa.jlogo.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to check the usage of the interface {@link Space}
 *
 * @author Luca Bianchi
 */
public class SpaceTest {

    @Test
    public void shouldNotCreateNewSpace() {
        assertThrows(IllegalArgumentException.class, () -> new GridSpace(100, -1));
        assertThrows(IllegalArgumentException.class, () -> new GridSpace(-1, 100));
    }

    @Test
    public void shouldCreateNewDefaultSpace() {
        Space space = new GridSpace(1000, 1000);
        assertEquals(new Coordinate2D(500.0, 500.0), space.getHome());
        assertEquals(new SimpleCursor(), space.getCursor());
        assertEquals(space.getHome(), space.getCursorPosition());
        assertEquals(0, space.getCursorDirection().getAngle());
    }

    @Test
    public void shouldReturnCorrectCursorDirection() {
        Space space = new GridSpace(1000, 1000);
        assertEquals(0, space.getCursorDirection().getAngle());
        space.getCursorDirection().leftRotation(new SimpleAngle(200));
        assertEquals(200, space.getCursorDirection().getAngle());
        space.getCursorDirection().rightRotation(new SimpleAngle(50));
        assertEquals(150, space.getCursorDirection().getAngle());
    }

    @Test
    public void shouldSetCursorAtNewCoordinate() {
        Space space = new GridSpace(1000, 1000);
        space.moveCursor(new Coordinate2D(400, 900));
        assertEquals(new Coordinate2D(400, 900), space.getCursorPosition());
    }

}
