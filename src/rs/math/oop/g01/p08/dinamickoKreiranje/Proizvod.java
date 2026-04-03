package rs.math.oop.g01.p08.dinamickoKreiranje;

import java.lang.reflect.Constructor;

class Proizvod {
    private String naziv;
    private double cena;

    public Proizvod() {
        this.naziv = "Непознат";
        this.cena = 0.0;
    }

    public Proizvod(String naziv, double cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Proizvod{назив='" + naziv
                + "', цена=" + cena + "}";
    }
}
