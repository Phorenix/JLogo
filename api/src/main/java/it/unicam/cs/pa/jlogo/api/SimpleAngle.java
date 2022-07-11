package it.unicam.cs.pa.jlogo.api;

/**
 * Class representing an angle, so it implements the interface Angle.
 */
public final class SimpleAngle implements Angle {

    // Integer that represents the angle itself
    private int angle;

    /**
     * In the constructor is checked if the given angle is valid (in range of 0-360) and if it is it assigns it to the
     * angle of the new instance
     *
     * @param angle the new angle that will be initialized
     */
    public SimpleAngle(int angle) {
        if (angle < 0 || angle > 360) {
            throw new IllegalArgumentException("Invalid argument, angle should positive and less than 360");
        }
        this.angle = angle;
    }

    // TODO returns a SimpleAngle?
    public SimpleAngle getComplementaryAngle() {
        return new SimpleAngle((this.angle + 180) % 360);
    }

    public int getAngle() {
        return angle;
    }

    public void leftRotation(Angle argAngle) {
        this.rotation(argAngle.getAngle());
    }

    public void rightRotation(Angle argAngle) {
        this.rotation(-argAngle.getAngle());
    }

    /**
     * Auxiliary method used to factor repetitive code of the 2 other rotation methods
     *
     * @param argAngle how much to rotate the angle (can be negative in case is called by the method rightRotation)
     */
    private void rotation(int argAngle) {

        // With the operator %, it will always keep the angle between 0  and 360
        this.angle = (this.angle + argAngle) % 360;
    }

}
