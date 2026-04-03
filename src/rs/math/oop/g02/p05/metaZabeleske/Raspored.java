package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Rasporedi.class)
@interface Raspored {
    String dan();
    int sat() default 12;
}
