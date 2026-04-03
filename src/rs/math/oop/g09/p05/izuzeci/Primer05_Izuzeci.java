package rs.math.oop.g09.p05.izuzeci;

import java.util.logging.*;

public class Primer05_Izuzeci {
    private static final Logger dnevnik =
        Logger.getLogger(
            Primer05_Izuzeci.class.getName());

    public static double podeli(int a, int b) {
        dnevnik.entering(
            "Primer05_Izuzeci", "podeli",
            new Object[]{a, b});
        double rezultat = (double) a / b;
        dnevnik.exiting(
            "Primer05_Izuzeci", "podeli",
            rezultat);
        return rezultat;
    }

    public static void main(String[] args) {
        try {
            int[] niz = {1, 2, 3};
            // Покушај приступа ван граница
            int vrednost = niz[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            dnevnik.log(Level.SEVERE,
                "Грешка при приступу низу", e);
        }

        try {
            int rezultat = 10 / 0;
        } catch (ArithmeticException e) {
            dnevnik.log(Level.WARNING,
                "Аритметичка грешка", e);
        }
    }
}
