package it.unicam.cs.pa.jlogo.api;

/**
 * Class representing an Angle.
 * In this implementation the angle is an int.
 * This class also is responsible for rotating the angle (left and right) with the appropriate methods.
 */
public final class Angle {
    private int angle;

    public Angle(int angle) {
        if (angle < 0 || angle > 360) {
            throw new IllegalArgumentException("Invalid argument, angle should positive and less than 360");
        }
        this.angle = angle;
    }

    public Angle getComplementaryAngle() {
        return new Angle((this.angle + 180) % 360);
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

    private void rotation(int argAngle) {
        this.angle = (this.angle + argAngle) % 360;
    }

}
