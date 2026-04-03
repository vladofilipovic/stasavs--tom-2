package rs.math.oop.g02.p01.osnovneZabeleske;

class Zaposleni {
    private String ime;
    private double plata;

    public Zaposleni(String ime, double plata) {
        this.ime = ime;
        this.plata = plata;
    }

    @Override
    public String toString() {
        return ime + " (плата: " + plata + ")";
    }

    @Deprecated(since = "2.0", forRemoval = true)
    public double dajPlatu() {
        return plata;
    }

    public double getPlata() {
        return plata;
    }

    public String getIme() {
        return ime;
    }
}
