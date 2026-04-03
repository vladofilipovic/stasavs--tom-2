package rs.math.oop.g03.p03.referenceNaMetode;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

class Poruka {
    private String tekst;

    public Poruka(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public String toString() {
        return "Порука{'" + tekst + "'}";
    }
}
