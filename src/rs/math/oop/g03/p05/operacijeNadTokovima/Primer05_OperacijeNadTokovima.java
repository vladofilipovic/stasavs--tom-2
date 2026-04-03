package rs.math.oop.g03.p05.operacijeNadTokovima;

import java.util.*;
import java.util.stream.*;

public class Primer05_OperacijeNadTokovima {
    public static void main(String[] args) {
        List<Zaposleni> zaposleni = Arrays.asList(
            new Zaposleni("Марко Илић", "ИТ", 120000),
            new Zaposleni("Ана Сарић", "ИТ", 135000),
            new Zaposleni("Јелена Ковач", "Финансије", 95000),
            new Zaposleni("Петар Стојић", "ИТ", 110000),
            new Zaposleni("Мила Радић", "Финансије", 105000),
            new Zaposleni("Иван Томић", "Маркетинг", 88000),
            new Zaposleni("Сара Петров", "Маркетинг", 92000)
        );

        // 1. filter – филтрирање елемената
        System.out.println("=== filter ===");
        List<Zaposleni> itZaposleni = zaposleni.stream()
            .filter(z -> z.odeljenje.equals("ИТ"))
            .collect(Collectors.toList());
        System.out.println("ИТ запослени: ");
        itZaposleni.forEach(z -> System.out.println("  " + z));

        // 2. map – трансформација елемената
        System.out.println("\n=== map ===");
        List<String> imena = zaposleni.stream()
            .map(z -> z.ime)
            .collect(Collectors.toList());
        System.out.println("Имена: " + imena);

        // mapToDouble за нумеричке операције
        double ukupnaPlata = zaposleni.stream()
            .mapToDouble(z -> z.plata)
            .sum();
        System.out.printf("Укупна плата: %.0f%n", ukupnaPlata);

        // 3. sorted – сортирање
        System.out.println("\n=== sorted ===");
        zaposleni.stream()
            .sorted(Comparator.comparingDouble(z -> z.plata))
            .forEach(z -> System.out.println("  " + z));

        // 4. distinct и limit
        System.out.println("\n=== distinct и limit ===");
        List<String> odeljenja = zaposleni.stream()
            .map(z -> z.odeljenje)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Одељења: " + odeljenja);

        List<Zaposleni> prvaTri = zaposleni.stream()
            .sorted(Comparator.comparingDouble((Zaposleni z) -> z.plata).reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Три највеће плате:");
        prvaTri.forEach(z -> System.out.println("  " + z));

        // 5. reduce – свођење на једну вредност
        System.out.println("\n=== reduce ===");
        Optional<Double> maxPlata = zaposleni.stream()
            .map(z -> z.plata)
            .reduce(Double::max);
        maxPlata.ifPresent(p -> System.out.printf("Максимална плата: %.0f%n", p));

        String svaImena = zaposleni.stream()
            .map(z -> z.ime)
            .reduce((a, b) -> a + ", " + b)
            .orElse("");
        System.out.println("Сва имена: " + svaImena);

        // 6. collect – сакупљање резултата
        System.out.println("\n=== collect (груписање) ===");
        Map<String, List<Zaposleni>> poOdeljenju = zaposleni.stream()
            .collect(Collectors.groupingBy(z -> z.odeljenje));
        poOdeljenju.forEach((od, lista) -> {
            System.out.println(od + ":");
            lista.forEach(z -> System.out.println("  " + z));
        });

        // Просечна плата по одељењу
        System.out.println("\n=== collect (просечна плата по одељењу) ===");
        Map<String, Double> prosecnaPlata = zaposleni.stream()
            .collect(Collectors.groupingBy(
                z -> z.odeljenje,
                Collectors.averagingDouble(z -> z.plata)));
        prosecnaPlata.forEach((od, pr) ->
            System.out.printf("  %s: %.0f%n", od, pr));

        // 7. anyMatch, allMatch, noneMatch
        System.out.println("\n=== anyMatch, allMatch, noneMatch ===");
        boolean imaVeliku = zaposleni.stream()
            .anyMatch(z -> z.plata > 130000);
        boolean sviPozitivni = zaposleni.stream()
            .allMatch(z -> z.plata > 0);
        boolean nemaNegatvinu = zaposleni.stream()
            .noneMatch(z -> z.plata < 0);
        System.out.println("Има плату > 130000: " + imaVeliku);
        System.out.println("Све плате > 0: " + sviPozitivni);
        System.out.println("Нема негативних: " + nemaNegatvinu);

        // 8. flatMap – спајање угњеждених токова
        System.out.println("\n=== flatMap ===");
        List<List<Integer>> liste = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> svi = liste.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println("Спојене листе: " + svi);

        // 9. peek – увид у елементе тока (за дебаговање)
        System.out.println("\n=== peek ===");
        List<String> rezultat = zaposleni.stream()
            .filter(z -> z.plata > 100000)
            .peek(z -> System.out.println("  После филтера: " + z.ime))
            .map(z -> z.ime.toUpperCase())
            .collect(Collectors.toList());
        System.out.println("Резултат: " + rezultat);
    }
}
