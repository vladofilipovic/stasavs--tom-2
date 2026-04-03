package rs.math.oop.g02.p06.refleksijaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Obavezno {
    String poruka() default "Поље је обавезно";
}
