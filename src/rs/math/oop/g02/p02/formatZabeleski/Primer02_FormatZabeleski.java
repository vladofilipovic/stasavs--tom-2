package rs.math.oop.g02.p02.formatZabeleski;

import java.lang.annotation.*;

public class Primer02_FormatZabeleski {
    public static void main(String[] args) {
        Class<?> klasa = KonvertorTemperature.class;

        // Провера маркер забелешке
        boolean testabilna = klasa.isAnnotationPresent(Testabilna.class);
        System.out.println("Да ли је класа означена као @Testabilna? " + testabilna);

        // Читање забелешке са више елемената
        Dokumentacija dok = klasa.getAnnotation(Dokumentacija.class);
        if (dok != null) {
            System.out.println("\nДокументација класе:");
            System.out.println("  Аутор: " + dok.autor());
            System.out.println("  Верзија: " + dok.verzija());
            System.out.println("  Опис: " + dok.opis());
            System.out.print("  Ознаке: ");
            for (String oznaka : dok.oznake()) {
                System.out.print("[" + oznaka + "] ");
            }
            System.out.println();
        }

        // Читање забелешки са метода
        System.out.println("\nМетоди класе:");
        for (java.lang.reflect.Method m : klasa.getDeclaredMethods()) {
            Autor autor = m.getAnnotation(Autor.class);
            if (autor != null) {
                System.out.println("  " + m.getName() + " – аутор: " + autor.value());
            }
        }

        // Демонстрација функционалности
        double c = 100;
        double f = KonvertorTemperature.celzijusUFarenhajt(c);
        System.out.println("\n" + c + "°C = " + f + "°F");
        System.out.println(f + "°F = " + KonvertorTemperature.farenhajdUCelzijus(f) + "°C");
    }
}
