package rs.math.oop.g01.p09.univerzalniToString;

import java.lang.reflect.*;

public class Primer09_UniverzalniToString {
    public static void main(String[] args) throws Exception {
        Tacka t = new Tacka(3.5, 7.2);
        System.out.println(univerzalniToString(t));

        Pravougaonik p = new Pravougaonik(
                new Tacka(1, 2), new Tacka(5, 8), "плава");
        System.out.println(univerzalniToString(p));

        int[] niz = {10, 20, 30, 40};
        System.out.println(univerzalniToString(niz));
    }

    public static String univerzalniToString(Object obj)
            throws Exception {
        if (obj == null) return "null";
        Class kl = obj.getClass();
        if (kl == String.class) return obj.toString();
        if (kl.isArray()) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) sb.append(", ");
                sb.append(univerzalniToString(Array.get(obj, i)));
            }
            return sb.append("]").toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(kl.getSimpleName()).append("{");
        boolean prvo = true;
        for (Field f : kl.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            try {
                f.setAccessible(true);
            } catch (InaccessibleObjectException e) {
                return obj.toString();
            }
            if (!prvo) sb.append(", ");
            prvo = false;
            sb.append(f.getName()).append("=");
            Object v = f.get(obj);
            if (f.getType() == String.class)
                sb.append("'").append(v).append("'");
            else if (!f.getType().isPrimitive() && v != null)
                sb.append(univerzalniToString(v));
            else sb.append(v);
        }
        return sb.append("}").toString();
    }
}
