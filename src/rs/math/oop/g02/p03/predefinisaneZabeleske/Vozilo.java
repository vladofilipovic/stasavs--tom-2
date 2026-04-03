package rs.math.oop.g02.p03.predefinisaneZabeleske;

import java.util.Arrays;
import java.util.List;

class Vozilo {
    private String marka;
    private int godiste;

    public Vozilo(String marka, int godiste) {
        this.marka = marka;
        this.godiste = godiste;
    }

    @Deprecated(since = "3.0", forRemoval = true)
    public String dajOpis() {
        return marka + " (" + godiste + ")";
    }

    public String getOpis() {
        return marka + " (" + godiste + ")";
    }

    @Override
    public String toString() {
        return getOpis();
    }

    @SafeVarargs
    public static <T> List<T> napraviListu(T... elementi) {
        return Arrays.asList(elementi);
    }
}
