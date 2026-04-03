package rs.math.oop.g02.p04.kreiranjeZabeleski;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface InfoKlase {
    String naziv();
    String[] autori();
    String datumKreiranja();
}
