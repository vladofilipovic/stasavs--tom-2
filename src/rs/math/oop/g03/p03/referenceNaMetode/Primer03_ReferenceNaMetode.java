package rs.math.oop.g03.p03.referenceNaMetode;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Primer03_ReferenceNaMetode {
    public static void main(String[] args) {
        List<String> reci = Arrays.asList("програмирање", "Јава", "ламбда", "ток", "функција");

        // 1. Референца на статички метод (Класа::статичкиМетод)
        System.out.println("=== Референца на статички метод ===");
        Function<String, Integer> duzina = Pomocna::brojSlova;
        reci.forEach(r -> System.out.println("  " + r + " -> " + duzina.apply(r) + " слова"));

        // 2. Референца на метод инстанце одређеног објекта (објекат::метод)
        System.out.println("\n=== Референца на метод одређеног објекта ===");
        Pomocna pom = new Pomocna(">>>");
        Consumer<String> stampaj = pom::stampajSaPrefiksom;
        reci.forEach(stampaj);

        // 3. Референца на метод инстанце произвољног објекта (Класа::метод)
        System.out.println("\n=== Референца на метод произвољног објекта ===");
        List<String> sortirano = reci.stream()
            .sorted(String::compareToIgnoreCase)
            .collect(Collectors.toList());
        System.out.println("Сортирано: " + sortirano);

        Function<String, String> uVelika = String::toUpperCase;
        List<String> velika = reci.stream()
            .map(uVelika)
            .collect(Collectors.toList());
        System.out.println("Велика слова: " + velika);

        // 4. Референца на конструктор (Класа::new)
        System.out.println("\n=== Референца на конструктор ===");
        Function<String, Poruka> napraviPoruku = Poruka::new;
        List<Poruka> poruke = reci.stream()
            .map(napraviPoruku)
            .collect(Collectors.toList());
        poruke.forEach(p -> System.out.println("  " + p));

        // Референца на конструктор низа
        IntFunction<String[]> napraviNiz = String[]::new;
        String[] niz = napraviNiz.apply(5);
        System.out.println("\nКреиран низ дужине: " + niz.length);

        // Комбиновање: toArray са референцом на конструктор
        String[] nizReci = reci.stream().toArray(String[]::new);
        System.out.println("Низ из тока: " + Arrays.toString(nizReci));
    }
}
