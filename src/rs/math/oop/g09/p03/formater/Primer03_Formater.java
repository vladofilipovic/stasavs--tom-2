package rs.math.oop.g09.p03.formater;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class Primer03_Formater {
    private static final Logger dnevnik =
        Logger.getLogger("МојДневник");

    public static void main(String[] args)
            throws Exception {
        // Конфигурација са прилагођеним форматером
        ConsoleHandler konzola =
            new ConsoleHandler();
        konzola.setFormatter(new MojFormater());
        konzola.setLevel(Level.ALL);

        dnevnik.addHandler(konzola);
        dnevnik.setLevel(Level.ALL);
        dnevnik.setUseParentHandlers(false);

        // Бележење порука
        dnevnik.info("Апликација покренута");
        dnevnik.warning("Мало меморије");
        dnevnik.severe("Веза са базом прекинута");
    }
}
