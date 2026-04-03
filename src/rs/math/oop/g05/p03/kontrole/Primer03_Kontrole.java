package rs.math.oop.g05.p03.kontrole;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Primer03_Kontrole extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Креирање контрола за форму
        Label naslov = new Label("Registracija");
        naslov.setStyle("-fx-font-size: 18px; "
            + "-fx-font-weight: bold;");

        TextField imePolje = new TextField();
        imePolje.setPromptText("Unesite ime");

        PasswordField lozinkaPolje = new PasswordField();
        lozinkaPolje.setPromptText("Unesite lozinku");

        CheckBox usloviPolje = new CheckBox(
            "Prihvatam uslove koriscenja");

        Button registrujSe = new Button("Registruj se");
        Label poruka = new Label();

        // Обрада догађаја клика на дугме
        registrujSe.setOnAction(event -> {
            String ime = imePolje.getText();
            boolean uslovi = usloviPolje.isSelected();

            if (ime.isEmpty()) {
                poruka.setText("Unesite ime!");
                poruka.setStyle("-fx-text-fill: red;");
            } else if (!uslovi) {
                poruka.setText("Morate prihvatiti uslove.");
                poruka.setStyle("-fx-text-fill: red;");
            } else {
                poruka.setText("Dobrodosli, " + ime + "!");
                poruka.setStyle("-fx-text-fill: green;");
            }
        });

        // Вертикални распоред са размаком од 10 пиксела
        VBox koren = new VBox(10, naslov, imePolje,
            lozinkaPolje, usloviPolje, registrujSe, poruka);
        koren.setPadding(new Insets(20));

        Scene scena = new Scene(koren, 350, 300);
        primaryStage.setTitle("Registracija");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
