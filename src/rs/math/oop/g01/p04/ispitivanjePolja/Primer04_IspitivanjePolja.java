package rs.math.oop.g01.p04.ispitivanjePolja;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Primer04_IspitivanjePolja {
    public static void main(String[] args) {
        Class klasa = Menadzer.class;

        System.out.println("=== Поља класе "
                + klasa.getSimpleName() + " ===");
        Field[] deklarisana = klasa.getDeclaredFields();
        for (Field f : deklarisana) {
            System.out.println("  "
                    + Modifier.toString(f.getModifiers())
                    + " " + f.getType().getSimpleName()
                    + " " + f.getName());
        }

        System.out.println("\n=== Поља наткласе ===");
        for (Field f : klasa.getSuperclass()
                .getDeclaredFields()) {
            System.out.println("  "
                    + Modifier.toString(f.getModifiers())
                    + " " + f.getType().getSimpleName()
                    + " " + f.getName());
        }
    }
}
