package rs.math.oop.g12.p04.datumVreme;

import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class Primer04_DatumVreme {
    public static void main(String[] args) {
        LocalDate danas = LocalDate.now();
        LocalDateTime sada = LocalDateTime.now();
 
        Locale[] lokali = {
            new Locale("sr", "RS"),
            Locale.US,
            Locale.GERMANY,
            Locale.JAPAN
        };
 
        // Форматирање датума
        System.out.println("Датум:");
        for (Locale lok : lokali) {
            DateTimeFormatter df =
            DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(lok);
            System.out.println(
            "  " + lok + ": "
            + danas.format(df));
        }
 
        // Форматирање времена
        System.out.println("\nДатум и време:");
        for (Locale lok : lokali) {
            DateTimeFormatter dtf =
            DateTimeFormatter
                .ofLocalizedDateTime(
                    FormatStyle.MEDIUM)
                .withLocale(lok);
            System.out.println(
            "  " + lok + ": "
            + sada.format(dtf));
        }
 
        // Прилагођени формат
        DateTimeFormatter prilagodjen =
        DateTimeFormatter.ofPattern(
            "EEEE, d. MMMM yyyy.",
            new Locale("sr", "RS"));
        System.out.println(
        "\nПрилагођено: "
        + danas.format(prilagodjen));
    }
}
