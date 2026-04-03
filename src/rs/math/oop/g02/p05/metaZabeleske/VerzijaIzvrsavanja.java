package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface VerzijaIzvrsavanja {
    String value();
}
