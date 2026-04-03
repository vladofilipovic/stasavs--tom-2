package rs.math.oop.g08.p04.introspekcija;

import java.beans.*;

public class Primer04_Introspekcija {
    public static void main(String[] args)
            throws Exception {
        BeanInfo info = Introspector.getBeanInfo(
            TemperaturaZrno.class, Object.class);

        // Приказ особина
        System.out.println("Особине:");
        for (PropertyDescriptor pd :
                info.getPropertyDescriptors()) {
            System.out.println("  "
                + pd.getName() + " : "
                + pd.getPropertyType()
                    .getSimpleName());
        }

        // Приказ метода
        System.out.println("\nМетоди:");
        for (MethodDescriptor md :
                info.getMethodDescriptors()) {
            System.out.println(
                "  " + md.getName() + "()");
        }

        // Приказ догађаја
        System.out.println("\nДогађаји:");
        for (EventSetDescriptor ed :
                info.getEventSetDescriptors()) {
            System.out.println(
                "  " + ed.getName());
        }
    }
}
