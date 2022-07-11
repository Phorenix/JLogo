package it.unicam.cs.pa.jlogo.api;

/**
 * Simple implementation of a Color interface
 *
 * @param red Red color based on the RGB colors
 * @param green Green color based on the RGB colors
 * @param blue Blue color based on the RGB colors
 */
public record RGBColor (int red, int green, int blue) implements Color {

    /**
     * In this constructor is only checked if the given color integers are valid in the RGB format
     *
     * @param red the red color of the RGB color passed
     * @param green the green color of the RGB color passed
     * @param blue the blue color of the RGB color passed
     */
    public RGBColor {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Invalid argument for a new RGB color");
        }
    }

}
