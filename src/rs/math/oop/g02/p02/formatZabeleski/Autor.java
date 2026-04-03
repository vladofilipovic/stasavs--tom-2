package rs.math.oop.g02.p02.formatZabeleski;

import java.lang.annotation.*;

// Забелешка са једним елементом (value)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Autor {
    String value();
}
