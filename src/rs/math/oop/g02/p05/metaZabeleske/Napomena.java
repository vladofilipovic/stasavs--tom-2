package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface Napomena {
    String value();
}
