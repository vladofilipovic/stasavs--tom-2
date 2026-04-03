package rs.math.oop.g03.p04.kreiranjeTokova;

import java.util.*;
import java.util.stream.*;

public class Primer04_KreiranjeTokova {
    public static void main(String[] args) {
        // 1. Ток из колекције
        System.out.println("=== Ток из колекције ===");
        List<String> lista = Arrays.asList("Јава", "ламбда", "ток", "функција");
        Stream<String> tokIzListe = lista.stream();
        tokIzListe.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 2. Ток из низа
        System.out.println("\n=== Ток из низа ===");
        int[] brojevi = {10, 20, 30, 40, 50};
        IntStream tokIzNiza = Arrays.stream(brojevi);
        System.out.println("Сума: " + tokIzNiza.sum());

        // Подток из низа (од индекса 1 до 3)
        IntStream podtok = Arrays.stream(brojevi, 1, 4);
        System.out.println("Подток [1,4): " + Arrays.toString(podtok.toArray()));

        // 3. Stream.of
        System.out.println("\n=== Stream.of ===");
        Stream<String> tokOd = Stream.of("један", "два", "три");
        tokOd.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 4. Празан ток
        System.out.println("\n=== Празан ток ===");
        Stream<String> prazan = Stream.empty();
        System.out.println("Број елемената празног тока: " + prazan.count());

        // 5. Stream.generate (бесконачан ток)
        System.out.println("\n=== Stream.generate ===");
        Stream<Double> slucajni = Stream.generate(Math::random).limit(5);
        slucajni.forEach(d -> System.out.printf("  %.4f%n", d));

        // 6. Stream.iterate
        System.out.println("\n=== Stream.iterate ===");
        // Класичан облик (Јава 8)
        Stream<Integer> parni = Stream.iterate(0, n -> n + 2).limit(8);
        System.out.println("Парни бројеви: " +
            parni.map(String::valueOf).collect(Collectors.joining(", ")));

        // Са предикатом (Јава 9)
        Stream<Integer> stepen = Stream.iterate(1, n -> n < 1024, n -> n * 2);
        System.out.println("Степени двојке: " +
            stepen.map(String::valueOf).collect(Collectors.joining(", ")));

        // 7. IntStream.range и rangeClosed
        System.out.println("\n=== IntStream.range и rangeClosed ===");
        IntStream opseg = IntStream.range(1, 6);   // [1, 6)
        IntStream opsegZ = IntStream.rangeClosed(1, 5); // [1, 5]
        System.out.println("range(1,6): " + Arrays.toString(opseg.toArray()));
        System.out.println("rangeClosed(1,5): " + Arrays.toString(opsegZ.toArray()));

        // 8. Ток из стринга (chars)
        System.out.println("\n=== Ток карактера из стринга ===");
        String tekst = "Java";
        tekst.chars().forEach(c -> System.out.print((char) c + " "));
        System.out.println();

        // 9. Паралелни ток
        System.out.println("\n=== Паралелни ток ===");
        long suma = LongStream.rangeClosed(1, 100).parallel().sum();
        System.out.println("Сума 1..100 (паралелно): " + suma);
    }
}
