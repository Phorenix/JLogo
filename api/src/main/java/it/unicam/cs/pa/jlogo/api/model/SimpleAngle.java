package it.unicam.cs.pa.jlogo.api.model;

/**
 * Class representing an angle, so it implements the interface {@link Angle}.
 *
 * @author Luca Bianchi
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

    public Angle getComplementaryAngle() {
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
        // With the operator %, it will always keep the angle between 0 and 360
        this.angle = (this.angle + argAngle) % 360;
        // This operation is necessary since java doesn't return the module of the operation, but the remainder, so
        // after % 360 it can still be negative.
        if (this.angle < 0) this.angle += 360;
    }

    /*
     * Override of equals method, otherwise it will just check if the given object is the same (in memory) of the
     * current angle
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Angle) obj;
        return this.getAngle() == that.getAngle();
    }

}
