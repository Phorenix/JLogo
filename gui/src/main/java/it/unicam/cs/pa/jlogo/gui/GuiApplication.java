package it.unicam.cs.pa.jlogo.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Class extending {@link Application}, so it will call the method start() when the javaFX routine takes control of
 * the execution
 *
 * @author Luca Bianchi
 */
public class GuiApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/LogoApp.fxml")));
        primaryStage.setTitle("Logo App");
        // Default dimensions (but is resizable)
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
