package rs.math.oop.g05.p04.povezivanje;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Primer04_Povezivanje extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField imePolje = new TextField();
        imePolje.setPromptText("Unesite ime");

        Label pozdrav = new Label();
        // Једносмерно повезивање: поздрав прати име
        pozdrav.textProperty().bind(
            Bindings.concat("Zdravo, ",
                imePolje.textProperty(), "!"));

        Slider velicinaSlajder = new Slider(10, 40, 20);
        velicinaSlajder.setShowTickLabels(true);

        // Повезивање величине фонта са клизачем
        pozdrav.styleProperty().bind(
            Bindings.concat("-fx-font-size: ",
                velicinaSlajder.valueProperty()
                    .asString("%.0f"),
                "px;"));

        CheckBox vidljivPolje = new CheckBox("Prikazi pozdrav");
        vidljivPolje.setSelected(true);

        // Повезивање видљивости
        pozdrav.visibleProperty().bind(
            vidljivPolje.selectedProperty());

        VBox koren = new VBox(15, imePolje,
            velicinaSlajder, vidljivPolje, pozdrav);
        koren.setPadding(new Insets(20));

        Scene scena = new Scene(koren, 400, 250);
        primaryStage.setTitle("Povezivanje svojstava");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
