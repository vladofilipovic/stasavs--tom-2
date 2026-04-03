package rs.math.oop.g01.p03.refleksijaGenerici;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

public class Primer03_RefleksijaGenerici {
    public static void main(String[] args) throws Exception {
        Class klasa = Skladiste.class;

        for (Field f : klasa.getDeclaredFields()) {
            Type gt = f.getGenericType();
            System.out.println("Поље: " + f.getName());
            System.out.println("  Генерички тип: " + gt);
            if (gt instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) gt;
                Type[] args2 = pt.getActualTypeArguments();
                System.out.print("  Аргументи типа: ");
                for (int i = 0; i < args2.length; i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(args2[i].getTypeName());
                }
                System.out.println();
            }
        }
    }
}
