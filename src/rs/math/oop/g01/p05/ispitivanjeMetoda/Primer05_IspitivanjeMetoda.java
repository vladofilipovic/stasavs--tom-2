package rs.math.oop.g01.p05.ispitivanjeMetoda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Primer05_IspitivanjeMetoda {
    public static void main(String[] args) {
        Class klasa = Osoba.class;
        Method[] metodi = klasa.getDeclaredMethods();

        for (Method m : metodi) {
            String mod = Modifier.toString(m.getModifiers());
            String tip = m.getReturnType().getSimpleName();
            Parameter[] params = m.getParameters();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(params[i].getType().getSimpleName());
            }
            System.out.println(mod + " " + tip
                    + " " + m.getName()
                    + "(" + sb.toString() + ")");
        }
    }
}
