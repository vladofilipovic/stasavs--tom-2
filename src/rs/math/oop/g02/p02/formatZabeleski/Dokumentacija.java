package rs.math.oop.g02.p02.formatZabeleski;

import java.lang.annotation.*;

// Забелешка са више елемената и подразумеваним вредностима
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Dokumentacija {
    String autor();
    String verzija() default "1.0";
    String opis() default "";
    String[] oznake() default {};
}
