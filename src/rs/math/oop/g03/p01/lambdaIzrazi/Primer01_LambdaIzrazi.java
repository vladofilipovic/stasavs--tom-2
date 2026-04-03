package rs.math.oop.g03.p01.lambdaIzrazi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Primer01_LambdaIzrazi {
    public static void main(String[] args) {
        // 1. Ламбда израз уместо анонимне класе
        System.out.println("=== Поређење: анонимна класа vs ламбда ===");

        Comparator<String> porAnonimna = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };

        Comparator<String> porLambda = (a, b) -> a.length() - b.length();

        List<String> reci = Arrays.asList("програмирање", "Јава", "ламбда", "ток", "функција");
        reci.sort(porLambda);
        System.out.println("Сортирано по дужини: " + reci);

        // 2. Различити облици ламбда израза
        System.out.println("\n=== Облици ламбда израза ===");

        // Без параметара
        Runnable pozdrav = () -> System.out.println("  Здраво из ламбда израза!");
        pozdrav.run();

        // Са једним параметром (заграде нису обавезне)
        Konvertor<String> velikaSlova = s -> s.toUpperCase();
        System.out.println("  Велика слова: " + velikaSlova.konvertuj("ламбда"));

        // Са више наредби (потребне витичасте заграде и return)
        Konvertor<String> formatiranje = s -> {
            String prvi = s.substring(0, 1).toUpperCase();
            String ostalo = s.substring(1).toLowerCase();
            return prvi + ostalo;
        };
        System.out.println("  Форматирано: " + formatiranje.konvertuj("програмирање"));

        // 3. Ламбда и финалне променљиве (енг. effectively final)
        System.out.println("\n=== Захватање променљивих ===");
        String prefiks = "Резултат";  // effectively final
        Konvertor<String> saPrefiks = s -> prefiks + ": " + s;
        System.out.println("  " + saPrefiks.konvertuj("вредност"));

        // 4. Ламбда у комбинацији са forEach
        System.out.println("\n=== forEach са ламбдом ===");
        List<Integer> brojevi = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("  Квадрати: ");
        brojevi.forEach(n -> System.out.print(n * n + " "));
        System.out.println();
    }
}
