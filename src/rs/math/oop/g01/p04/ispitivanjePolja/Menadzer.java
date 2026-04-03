package rs.math.oop.g01.p04.ispitivanjePolja;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Menadzer extends Zaposleni {
    private double bonus;

    public Menadzer(String ime, double plata,
            int godineStaza, String odeljenje, double bonus) {
        super(ime, plata, godineStaza, odeljenje);
        this.bonus = bonus;
    }
}
