package rs.math.oop.g03.p03.referenceNaMetode;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

class Pomocna {
    private String prefiks;

    public Pomocna(String prefiks) {
        this.prefiks = prefiks;
    }

    public static int brojSlova(String s) {
        return s.length();
    }

    public void stampajSaPrefiksom(String s) {
        System.out.println("  " + prefiks + " " + s);
    }
}
