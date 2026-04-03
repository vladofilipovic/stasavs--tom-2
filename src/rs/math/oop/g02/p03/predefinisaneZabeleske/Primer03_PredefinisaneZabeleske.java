package rs.math.oop.g02.p03.predefinisaneZabeleske;

import java.util.Arrays;
import java.util.List;

public class Primer03_PredefinisaneZabeleske {

    @SuppressWarnings({"deprecation", "removal"})
    public static void main(String[] args) {
        Vozilo v1 = new Vozilo("Фиат Пунто", 2018);
        Vozilo v2 = new Vozilo("Шкода Октавија", 2021);

        // Позив застарелог метода
        System.out.println("Застарели метод: " + v1.dajOpis());
        System.out.println("Нови метод: " + v1.getOpis());

        // @SafeVarargs – нема упозорења за генерички варарг
        List<Vozilo> vozila = Vozilo.napraviListu(v1, v2);
        System.out.println("\nЛиста возила:");
        for (Vozilo v : vozila) {
            System.out.println("  " + v);
        }

        // Информације о застарелим методима преко рефлексије
        System.out.println("\nИнформације о застарелим методима:");
        for (java.lang.reflect.Method m : Vozilo.class.getDeclaredMethods()) {
            Deprecated dep = m.getAnnotation(Deprecated.class);
            if (dep != null) {
                System.out.println("  Метод: " + m.getName());
                System.out.println("  Застарео од верзије: " + dep.since());
                System.out.println("  Планирано уклањање: " + dep.forRemoval());
            }
        }
    }
}
