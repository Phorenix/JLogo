package it.unicam.cs.pa.jlogo.api.io;

import it.unicam.cs.pa.jlogo.api.shapes.Shape;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record DefaultFileWriter(ShapeWriter shapeWriter) implements FileWriter {

    @Override
    public void writeShapesIntoFile(Path path, List<Shape> shapesList) throws IOException {
        Files.write(path, this.shapeWriter.stringOf(shapesList).getBytes());
    }
}
