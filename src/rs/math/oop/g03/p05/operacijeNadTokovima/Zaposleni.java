package rs.math.oop.g03.p05.operacijeNadTokovima;

import java.util.*;
import java.util.stream.*;

class Zaposleni {
    String ime;
    String odeljenje;
    double plata;

    public Zaposleni(String ime, String odeljenje, double plata) {
        this.ime = ime;
        this.odeljenje = odeljenje;
        this.plata = plata;
    }

    @Override
    public String toString() {
        return ime + " (" + odeljenje + ", " + String.format("%.0f", plata) + ")";
    }
}
