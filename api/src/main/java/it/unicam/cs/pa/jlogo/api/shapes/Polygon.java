package it.unicam.cs.pa.jlogo.api.shapes;

import java.util.List;
import java.util.Objects;

public record Polygon(List<Line> lines) implements Figure {

    public Polygon(List<Line> lines) {
        this.lines = Objects.requireNonNull(lines);
    }

    @Override
    public int getNumberOfSegments() {
        return this.lines.size();
    }
}
