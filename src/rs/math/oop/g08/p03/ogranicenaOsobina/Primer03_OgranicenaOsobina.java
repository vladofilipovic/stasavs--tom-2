package rs.math.oop.g08.p03.ogranicenaOsobina;

import java.beans.*;
import java.io.Serializable;

public class Primer03_OgranicenaOsobina {
    public static void main(String[] args) {
        OcenaZrno zrno = new OcenaZrno();

        // Ослушкивач који одбија неважеће оцене
        zrno.addVetoableChangeListener(e -> {
            int nova = (int) e.getNewValue();
            if (nova < 5 || nova > 10) {
                throw new PropertyVetoException(
                    "Оцена мора бити између 5 и 10",
                    e);
            }
        });

        // Ослушкивач промене
        zrno.addPropertyChangeListener(e ->
            System.out.println("Оцена промењена: "
                + e.getOldValue()
                + " -> " + e.getNewValue()));

        // Покушај валидних и невалидних промена
        try {
            zrno.setOcena(9);
            System.out.println(
                "Оцена: " + zrno.getOcena());

            zrno.setOcena(11);
        } catch (PropertyVetoException e) {
            System.out.println(
                "Одбијено: " + e.getMessage());
            System.out.println(
                "Оцена остала: "
                + zrno.getOcena());
        }
    }
}
