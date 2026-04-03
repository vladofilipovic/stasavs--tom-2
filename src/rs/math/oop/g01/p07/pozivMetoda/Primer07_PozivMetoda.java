package rs.math.oop.g01.p07.pozivMetoda;

import java.lang.reflect.Method;

public class Primer07_PozivMetoda {
    public static void main(String[] args) throws Exception {
        Kalkulator kalk = new Kalkulator();
        Class klasa = kalk.getClass();

        // Позивање јавног метода
        Method saberi = klasa.getMethod("saberi",
                int.class, int.class);
        System.out.println("saberi(15, 27) = "
                + saberi.invoke(kalk, 15, 27));

        // Позивање приватног метода
        Method tajni = klasa.getDeclaredMethod("tajnaPoruka");
        tajni.setAccessible(true);
        System.out.println("tajnaPoruka() = "
                + tajni.invoke(kalk));

        // Позивање статичког метода
        Method kvadrat = klasa.getMethod("kvadrat", int.class);
        System.out.println("kvadrat(7) = "
                + kvadrat.invoke(null, 7));
    }
}
