package rs.math.oop.g02.p04.kreiranjeZabeleski;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    String opis() default "";
    int prioritet() default 0;
    boolean preskoci() default false;
}
