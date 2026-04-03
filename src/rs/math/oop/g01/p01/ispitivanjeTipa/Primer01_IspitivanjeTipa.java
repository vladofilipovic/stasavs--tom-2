package rs.math.oop.g01.p01.ispitivanjeTipa;

import java.lang.reflect.*;

public class Primer01_IspitivanjeTipa {
    public static void main(String[] args) {
        // Добијање објекта класе Class на три начина

        // 1. Преко метода getClass()
        String s = "Здраво";
        Class c1 = s.getClass();
        System.out.println("1. Преко getClass(): " + c1.getName());

        // 2. Преко литерала .class
        Class c2 = String.class;
        System.out.println("2. Преко .class: " + c2.getName());

        // 3. Преко статичког метода Class.forName()
        try {
            Class c3 = Class.forName("java.util.Date");
            System.out.println("3. Преко forName(): " + c3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Испитивање наткласе
        System.out.println("\nНаткласа од Integer: "
                + Integer.class.getSuperclass().getName());

        // Провера типа помоћу instanceof и getClass()
        Number n = Integer.valueOf(42);
        System.out.println("\nn instanceof Number: " + (n instanceof Number));
        System.out.println("n.getClass() == Integer.class: "
                + (n.getClass() == Integer.class));

        // Испитивање интерфејса
        Class[] interfejsi = Integer.class.getInterfaces();
        System.out.println("\nИнтерфејси класе Integer:");
        for (Class i : interfejsi) {
            System.out.println("  " + i.getName());
        }

        // Испитивање низова
        int[] niz = {1, 2, 3};
        System.out.println("\nТип низа int[]: " + niz.getClass().getName());
        System.out.println("Да ли је низ: " + niz.getClass().isArray());
        System.out.println("Тип елемента низа: "
                + niz.getClass().getComponentType().getName());
    }
}
