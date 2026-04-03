package rs.math.oop.g01.p04.ispitivanjePolja;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Zaposleni {
    private String ime;
    private double plata;
    protected int godineStaza;
    public String odeljenje;

    public Zaposleni(String ime, double plata,
            int godineStaza, String odeljenje) {
        this.ime = ime;
        this.plata = plata;
        this.godineStaza = godineStaza;
        this.odeljenje = odeljenje;
    }
}
