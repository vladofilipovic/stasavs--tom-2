package rs.math.oop.g05.p01.osnovnaAplikacija;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Primer01_OsnovnaAplikacija extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Креирање ознаке и контејнера
        Label oznaka = new Label("Zdravo, JavaFX!");
        oznaka.setStyle("-fx-font-size: 24px;");

        StackPane koren = new StackPane();
        koren.getChildren().add(oznaka);

        // Креирање сцене и подешавање позорнице
        Scene scena = new Scene(koren, 400, 300);

        primaryStage.setTitle("Prva JavaFX aplikacija");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
