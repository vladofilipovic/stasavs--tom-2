package rs.math.oop.g03.p02.funkcionalniInterfejsi;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Primer02_FunkcionalniInterfejsi {
    public static void main(String[] args) {
        List<String> imena = Arrays.asList("Марко", "Ана", "Јелена", "Ив", "Александар");

        // 1. Predicate – прима T, враћа boolean
        System.out.println("=== Predicate ===");
        Predicate<String> duzeOdTri = s -> s.length() > 3;
        Predicate<String> pocinjeSaA = s -> s.startsWith("А");

        System.out.println("Дужа од 3 карактера: " +
            imena.stream().filter(duzeOdTri).collect(Collectors.toList()));
        System.out.println("Почињу са А: " +
            imena.stream().filter(pocinjeSaA).collect(Collectors.toList()));
        System.out.println("Дужа од 3 И почињу са А: " +
            imena.stream().filter(duzeOdTri.and(pocinjeSaA)).collect(Collectors.toList()));
        System.out.println("Негација (НЕ дужа од 3): " +
            imena.stream().filter(duzeOdTri.negate()).collect(Collectors.toList()));

        // 2. Function – прима T, враћа R
        System.out.println("\n=== Function ===");
        Function<String, Integer> duzina = String::length;
        Function<Integer, String> uTekst = n -> "(" + n + " слова)";

        // Композиција: andThen и compose
        Function<String, String> duzinaTekst = duzina.andThen(uTekst);
        for (String ime : imena) {
            System.out.println("  " + ime + " -> " + duzinaTekst.apply(ime));
        }

        // 3. Consumer – прима T, не враћа ништа
        System.out.println("\n=== Consumer ===");
        Consumer<String> stampaj = s -> System.out.print("[" + s + "] ");
        System.out.print("  Имена: ");
        imena.forEach(stampaj);
        System.out.println();

        // BiConsumer
        BiConsumer<String, Integer> stampajPar = (ime, rb) ->
            System.out.println("  " + rb + ". " + ime);
        System.out.println("  Са редним бројем:");
        for (int i = 0; i < imena.size(); i++) {
            stampajPar.accept(imena.get(i), i + 1);
        }

        // 4. Supplier – не прима ништа, враћа T
        System.out.println("\n=== Supplier ===");
        Supplier<Double> slucajan = Math::random;
        System.out.println("  Случајни бројеви:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%.4f%n", slucajan.get());
        }

        // 5. UnaryOperator и BinaryOperator
        System.out.println("\n=== UnaryOperator и BinaryOperator ===");
        UnaryOperator<String> velikaSlova = String::toUpperCase;
        BinaryOperator<String> spoji = (a, b) -> a + " " + b;

        System.out.println("  Велика слова: " + velikaSlova.apply("ламбда"));
        System.out.println("  Спајање: " + spoji.apply("Јава", "програмирање"));

        String spojena = imena.stream().reduce("", spoji);
        System.out.println("  Сва имена: " + spojena.trim());
    }
}
