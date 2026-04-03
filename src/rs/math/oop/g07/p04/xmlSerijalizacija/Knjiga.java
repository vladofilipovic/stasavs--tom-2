package rs.math.oop.g07.p04.xmlSerijalizacija;

import java.beans.*;
import java.io.*;

public class Knjiga {
    private String naslov;
    private String autor;
    private int godina;

    public Knjiga() {}

    public Knjiga(String naslov, String autor,
            int godina) {
        this.naslov = naslov;
        this.autor = autor;
        this.godina = godina;
    }

    // Методи за добијање вредности
    public String getNaslov() { return naslov; }
    public String getAutor() { return autor; }
    public int getGodina() { return godina; }

    // Методи за постављање вредности
    public void setNaslov(String n) { naslov = n; }
    public void setAutor(String a) { autor = a; }
    public void setGodina(int g) { godina = g; }

    @Override
    public String toString() {
        return naslov + " - " + autor
            + " (" + godina + ")";
    }
}
