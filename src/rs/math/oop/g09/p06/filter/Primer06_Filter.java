package rs.math.oop.g09.p06.filter;

import java.util.logging.*;

public class Primer06_Filter {
    private static final Logger dnevnik =
        Logger.getLogger("ФилтерДневник");

    public static void main(String[] args) {
        ConsoleHandler konzola =
            new ConsoleHandler();
        konzola.setLevel(Level.ALL);
        dnevnik.addHandler(konzola);
        dnevnik.setLevel(Level.ALL);
        dnevnik.setUseParentHandlers(false);

        // Филтер: само поруке о бази
        dnevnik.setFilter(zapis ->
            zapis.getMessage()
                .contains("баз"));

        dnevnik.info("Апликација покренута");
        dnevnik.info("Повезивање са базом");
        dnevnik.info("Учитавање података");
        dnevnik.warning("Веза са базом прекинута");
        dnevnik.info("Завршетак рада");
    }
}
