package it.unicam.cs.pa.jlogo.api;

// TODO Check if it's ok, as well as Coordinate. Also the methods needs to be (Color color) o (RGBColor color)?

/**
 * This interface represents a classic RGB color (that will be used for a generic Shape)
 */
public interface Color {

    /**
     * Returns the red color of the RGB color format
     *
     * @return the red color of the RGB color format
     */
    int red();

    /**
     * Returns the green color of the RGB color format
     *
     * @return the green color of the RGB color format
     */
    int green();

    /**
     * Returns the blue color of the RGB color format
     *
     * @return the blue color of the RGB color format
     */
    int blue();

}
