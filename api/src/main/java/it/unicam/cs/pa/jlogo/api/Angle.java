package it.unicam.cs.pa.jlogo.api;

/**
 * This interface has the responsibility to represent an angle in the space (that will be used as the direction of the
 * cursor).
 * In this implementation the angle is an int.
 * This interface also is responsible for rotating the angle (left and right) with the appropriate methods.
 */
public interface Angle {

    /**
     * Returns the complementary angle (that is angle + 180) of the current one.
     *
     * @return the complementary angle (that is angle + 180) of the current one.
     */
    Angle getComplementaryAngle();

    /**
     * Returns the angle (that is an integer)
     *
     * @return the angle
     */
    int getAngle();

    /**
     * Rotate the angle "left" (so counterclockwise)
     *
     * @param argAngle how much to rotate the angle left
     */
    void leftRotation(Angle argAngle);

    /**
     * Rotate the angle "right" (so clockwise)
     *
     * @param argAngle how much to rotate the angle right
     */
    void rightRotation(Angle argAngle);

}
