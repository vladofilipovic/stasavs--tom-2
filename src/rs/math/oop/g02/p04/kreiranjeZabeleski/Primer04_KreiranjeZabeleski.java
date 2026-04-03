package rs.math.oop.g02.p04.kreiranjeZabeleski;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Primer04_KreiranjeZabeleski {

    static void validiraj(Object objekat) throws Exception {
        Class klasa = objekat.getClass();
        for (Field polje : klasa.getDeclaredFields()) {
            Opseg opseg = polje.getAnnotation(Opseg.class);
            if (opseg != null) {
                polje.setAccessible(true);
                double vrednost = polje.getDouble(objekat);
                if (vrednost < opseg.min() || vrednost > opseg.max()) {
                    System.out.println("  ГРЕШКА: " + polje.getName()
                        + " = " + vrednost + " – " + opseg.poruka());
                } else {
                    System.out.println("  ОК: " + polje.getName()
                        + " = " + vrednost + " (опсег: ["
                        + opseg.min() + ", " + opseg.max() + "])");
                }
            }
        }
    }

    static void pokreniTestove(Object objekat) throws Exception {
        Class klasa = objekat.getClass();
        System.out.println("Покретање тестова за " + klasa.getSimpleName() + ":");
        for (Method metod : klasa.getDeclaredMethods()) {
            Test test = metod.getAnnotation(Test.class);
            if (test != null) {
                if (test.preskoci()) {
                    System.out.println("  ПРЕСКОЧЕН: " + metod.getName()
                        + " – " + test.opis());
                    continue;
                }
                System.out.println("  ТЕСТ [приоритет=" + test.prioritet() + "]: "
                    + metod.getName() + " – " + test.opis());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Читање @InfoKlase
        InfoKlase info = Kalkulator.class.getAnnotation(InfoKlase.class);
        System.out.println("Информације о класи:");
        System.out.println("  Назив: " + info.naziv());
        System.out.print("  Аутори: ");
        for (String autor : info.autori()) System.out.print(autor + ", ");
        System.out.println("\n  Датум креирања: " + info.datumKreiranja());

        // Валидација поља
        System.out.println("\nВалидација поља:");
        Kalkulator k1 = new Kalkulator(42);
        validiraj(k1);
        System.out.println();
        Kalkulator k2 = new Kalkulator(5000);
        validiraj(k2);

        // Покретање тестова
        System.out.println();
        pokreniTestove(k1);
    }
}

