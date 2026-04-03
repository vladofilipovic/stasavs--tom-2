package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Serijalizabilna {
    String format() default "JSON";
}
