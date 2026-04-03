package rs.math.oop.g01.p08.dinamickoKreiranje;

import java.lang.reflect.Constructor;

public class Primer08_DinamickoKreiranje {
    public static void main(String[] args) throws Exception {
        Class klasa = Proizvod.class;

        // Подразумевани конструктор
        Constructor c1 = klasa.getDeclaredConstructor();
        System.out.println(c1.newInstance());

        // Конструктор са параметрима
        Constructor c2 = klasa.getDeclaredConstructor(
                String.class, double.class);
        System.out.println(c2.newInstance("Лаптоп", 89999.99));

        // Динамичко креирање преко имена класе
        Class din = Class.forName("rs.math.oop.g01.p08.dinamickoKreiranje.Proizvod");
        Constructor c3 = din.getDeclaredConstructor(
                String.class, double.class);
        System.out.println(c3.newInstance("Телефон", 45000.0));
    }
}
