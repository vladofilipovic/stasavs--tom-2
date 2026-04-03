package rs.math.oop.g05.p02.rasporediIKontrole;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Primer02_RasporediIKontrole extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Горњи део - HBox са дугмадима
        Button dugmeNovo = new Button("Novo");
        Button dugmeSacuvaj = new Button("Sacuvaj");
        Button dugmeObrisi = new Button("Obrisi");

        HBox traka = new HBox(10, dugmeNovo, dugmeSacuvaj,
            dugmeObrisi);
        traka.setPadding(new Insets(10));
        traka.setAlignment(Pos.CENTER_LEFT);

        // Централни део - GridPane са формом
        GridPane forma = new GridPane();
        forma.setHgap(10);
        forma.setVgap(10);
        forma.setPadding(new Insets(20));

        forma.add(new Label("Ime:"), 0, 0);
        forma.add(new TextField(), 1, 0);
        forma.add(new Label("Prezime:"), 0, 1);
        forma.add(new TextField(), 1, 1);
        forma.add(new Label("Email:"), 0, 2);
        forma.add(new TextField(), 1, 2);

        CheckBox aktivan = new CheckBox("Aktivan korisnik");
        forma.add(aktivan, 1, 3);

        // Доњи део - HBox са статусом
        Label status = new Label("Spremno.");
        HBox statusTraka = new HBox(status);
        statusTraka.setPadding(new Insets(5, 10, 5, 10));

        // BorderPane као главни распоред
        BorderPane glavni = new BorderPane();
        glavni.setTop(traka);
        glavni.setCenter(forma);
        glavni.setBottom(statusTraka);

        Scene scena = new Scene(glavni, 450, 300);

        primaryStage.setTitle("Forma sa rasporedom");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
