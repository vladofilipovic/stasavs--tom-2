package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Rasporedi {
    Raspored[] value();
}
