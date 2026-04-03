package rs.math.oop.g01.p02.refleksijaNizovi;

import java.lang.reflect.Array;

public class Primer02_RefleksijaNizovi {
    public static void main(String[] args) {
        // Динамичко креирање низа
        Object niz = Array.newInstance(int.class, 5);
        for (int i = 0; i < 5; i++) {
            Array.setInt(niz, i, (i + 1) * 10);
        }
        System.out.println("Динамички креиран низ int[]:");
        for (int i = 0; i < Array.getLength(niz); i++) {
            System.out.print("  " + Array.getInt(niz, i));
        }
        System.out.println();

        // Генерички метод за проширивање низа
        int[] original = {1, 2, 3, 4, 5};
        int[] prosiren = (int[]) prosiriNiz(original, 10);
        System.out.println("\nПроширени низ (дужина "
                + prosiren.length + "):");
        for (int v : prosiren) {
            System.out.print("  " + v);
        }
        System.out.println();
    }

    public static Object prosiriNiz(Object niz, int novaDuzina) {
        Class tipKlase = niz.getClass();
        if (!tipKlase.isArray())
            throw new IllegalArgumentException("Није низ!");
        Class tipElementa = tipKlase.getComponentType();
        int staraDuzina = Array.getLength(niz);
        Object noviNiz = Array.newInstance(tipElementa, novaDuzina);
        System.arraycopy(niz, 0, noviNiz, 0,
                Math.min(staraDuzina, novaDuzina));
        return noviNiz;
    }
}
