package rs.math.oop.g09.p02.obradivaci;

import java.io.IOException;
import java.util.logging.*;

public class Primer02_Obradivaci {
    private static final Logger dnevnik =
        Logger.getLogger(
            Primer02_Obradivaci.class.getName());

    public static void main(String[] args)
            throws IOException {
        // Креирање обрађивача за датотеку
        FileHandler fajl = new FileHandler(
            "aplikacija.log", true);
        fajl.setLevel(Level.ALL);
        fajl.setFormatter(new SimpleFormatter());

        // Креирање обрађивача за конзолу
        ConsoleHandler konzola =
            new ConsoleHandler();
        konzola.setLevel(Level.WARNING);

        // Подешавање дневника
        dnevnik.addHandler(fajl);
        dnevnik.addHandler(konzola);
        dnevnik.setLevel(Level.ALL);
        // Искључивање подразумеваног обрађивача
        dnevnik.setUseParentHandlers(false);

        // Бележење порука
        dnevnik.severe("Критична грешка");
        dnevnik.warning("Упозорење");
        dnevnik.info("Информација");
        dnevnik.fine("Детаљна порука");
        dnevnik.finest("Најдетаљнија порука");

        System.out.println(
            "Дневник записан у aplikacija.log");

        // Затварање обрађивача
        fajl.close();
    }
}
