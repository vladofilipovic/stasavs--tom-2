package rs.math.oop.g02.p01.osnovneZabeleske;

import java.util.ArrayList;
import java.util.List;

public class Primer01_OsnovneZabeleske {
    @SuppressWarnings({"deprecation", "removal"})
    public static void main(String[] args) {
        // 1. Употреба @Override
        Zaposleni z = new Zaposleni("Марко Илић", 95000);
        System.out.println("toString(): " + z);

        // 2. Употреба @Deprecated – компајлер даје упозорење
        double plata = z.dajPlatu();
        System.out.println("Застарели метод dajPlatu(): " + plata);
        System.out.println("Нови метод getPlata(): " + z.getPlata());

        // 3. Употреба @SuppressWarnings
        @SuppressWarnings("unchecked")
        List lista = new ArrayList();
        lista.add("текст");
        System.out.println("Листа (без упозорења): " + lista);

        // 4. Употреба @FunctionalInterface са ламбда изразом
        Konvertor<String, Integer> uCeoBroj = Integer::parseInt;
        Konvertor<Double, String> uTekst = d -> String.format("%.2f", d);

        System.out.println("Конверзија \"123\": " + uCeoBroj.konvertuj("123"));
        System.out.println("Конверзија 3.14159: " + uTekst.konvertuj(3.14159));
    }
}
