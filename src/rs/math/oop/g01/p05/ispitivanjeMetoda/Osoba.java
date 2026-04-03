package rs.math.oop.g01.p05.ispitivanjeMetoda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

class Osoba {
    private String ime;
    private int godine;

    public Osoba(String ime, int godine) {
        this.ime = ime;
        this.godine = godine;
    }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }
    public int getGodine() { return godine; }
    private void tajniMetod(String poruka) {
        System.out.println(poruka);
    }
    public String predstaviSe() {
        return "Ја сам " + ime + ", имам "
                + godine + " година.";
    }
}
