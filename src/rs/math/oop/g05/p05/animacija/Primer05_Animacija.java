package rs.math.oop.g05.p05.animacija;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Primer05_Animacija extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane koren = new Pane();

        // Креирање кругова са анимацијом
        for (int i = 0; i < 5; i++) {
            Circle krug = new Circle(15 + i * 5);
            krug.setFill(Color.hsb(i * 60, 0.8, 0.9));
            krug.setCenterX(50 + i * 70);
            krug.setCenterY(150);

            // Вертикална анимација
            TranslateTransition tt =
                new TranslateTransition(
                    Duration.seconds(1 + i * 0.3), krug);
            tt.setByY(-100 + i * 10);
            tt.setCycleCount(Animation.INDEFINITE);
            tt.setAutoReverse(true);

            // Ротација
            RotateTransition rt =
                new RotateTransition(
                    Duration.seconds(2), krug);
            rt.setByAngle(360);
            rt.setCycleCount(Animation.INDEFINITE);

            // Промена величине
            ScaleTransition st =
                new ScaleTransition(
                    Duration.seconds(1.5 + i * 0.2),
                    krug);
            st.setToX(1.5);
            st.setToY(1.5);
            st.setCycleCount(Animation.INDEFINITE);
            st.setAutoReverse(true);

            // Покретање свих анимација паралелно
            ParallelTransition pt =
                new ParallelTransition(krug,
                    tt, rt, st);
            pt.play();

            koren.getChildren().add(krug);
        }

        Scene scena = new Scene(koren, 500, 350);
        primaryStage.setTitle("Animacija");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
