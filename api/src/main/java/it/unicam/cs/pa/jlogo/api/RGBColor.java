package it.unicam.cs.pa.jlogo.api;

public record RGBColor (int red, int green, int blue) implements Color {

    public RGBColor {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Invalid argument for a new RGB color");
        }
    }

}
