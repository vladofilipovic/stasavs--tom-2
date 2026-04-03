package rs.math.oop.g02.p06.refleksijaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Duzina {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    String poruka() default "Неисправна дужина";
}
