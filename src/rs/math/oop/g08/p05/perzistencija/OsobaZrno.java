package rs.math.oop.g08.p05.perzistencija;

import java.io.Serializable;

public class OsobaZrno implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ime;
    private String prezime;
    private int godine;

    public OsobaZrno() {
        this.ime = "";
        this.prezime = "";
        this.godine = 0;
    }

    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public int getGodine() { return godine; }

    public void setIme(String ime) { this.ime = ime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }
    public void setGodine(int godine) { this.godine = godine; }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + godine + ")";
    }
}
