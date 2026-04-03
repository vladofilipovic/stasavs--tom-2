package rs.math.oop.g02.p04.kreiranjeZabeleski;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Opseg {
    double min() default Double.MIN_VALUE;
    double max() default Double.MAX_VALUE;
    String poruka() default "Вредност је ван опсега";
}
