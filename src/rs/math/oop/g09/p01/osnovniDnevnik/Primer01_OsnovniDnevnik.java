package rs.math.oop.g09.p01.osnovniDnevnik;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Primer01_OsnovniDnevnik {
    // Креирање дневника за ову класу
    private static final Logger dnevnik =
        Logger.getLogger(
            Primer01_OsnovniDnevnik.class
                .getName());

    public static void main(String[] args) {
        // Бележење порука различитих нивоа
        dnevnik.severe("Критична грешка!");
        dnevnik.warning("Упозорење.");
        dnevnik.info("Информација.");
        dnevnik.config("Конфигурација.");
        dnevnik.fine("Детаљна порука.");
        dnevnik.finer("Још детаљнија порука.");
        dnevnik.finest("Најдетаљнија порука.");

        // Бележење са експлицитним нивоом
        dnevnik.log(Level.INFO,
            "Апликација покренута.");

        // Бележење са параметрима
        String korisnik = "Марко";
        dnevnik.log(Level.INFO,
            "Корисник {0} се пријавио.",
            korisnik);
    }
}
