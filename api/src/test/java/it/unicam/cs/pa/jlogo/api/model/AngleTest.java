package it.unicam.cs.pa.jlogo.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class to check the usage of the interface {@link Angle}
 *
 * @author Luca Bianchi
 */
public class AngleTest {

    @Test
    public void shouldNotCreateNewAngle() {
        assertThrows(IllegalArgumentException.class, () -> new SimpleAngle(-1));
        assertThrows(IllegalArgumentException.class, () -> new SimpleAngle(361));
    }

    @Test
    public void shouldReturnComplementaryAngle() {
        Angle angle1 = new SimpleAngle(20);
        assertEquals(200, angle1.getComplementaryAngle().getAngle());
        Angle angle2 = new SimpleAngle(300);
        assertEquals(120, angle2.getComplementaryAngle().getAngle());
    }

    @Test
    public void shouldReturnTrueOn2IdenticalAngles() {
        Angle angle1 = new SimpleAngle(100);
        Angle angle2 = new SimpleAngle(100);
        assertEquals(angle1, angle2);
        Angle angle3 = new SimpleAngle(280);
        assertEquals(angle1, angle3.getComplementaryAngle());
    }

    @Test
    public void shouldLeftRotateAngle() {
        Angle angle = new SimpleAngle(100);
        angle.leftRotation(new SimpleAngle(200));
        assertEquals(300, angle.getAngle());
    }

    @Test
    public void shouldRightRotateAngle() {
        Angle angle = new SimpleAngle(100);
        angle.rightRotation(new SimpleAngle(200));
        assertEquals(260, angle.getAngle());
    }

}
