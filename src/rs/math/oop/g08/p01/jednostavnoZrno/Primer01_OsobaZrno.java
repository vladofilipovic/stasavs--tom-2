package rs.math.oop.g08.p01.jednostavnoZrno;

import java.io.Serializable;

public class Primer01_OsobaZrno
    implements Serializable {
    private static final long serialVersionUID = 1L;

    // Приватна поља – особине зрна
    private String ime;
    private String prezime;
    private int godine;

    // Подразумевани конструктор – обавезан
    public Primer01_OsobaZrno() {
        this.ime = "";
        this.prezime = "";
        this.godine = 0;
    }

    // Параметризовани конструктор
    public Primer01_OsobaZrno(String ime,
            String prezime, int godine) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    // Методи за добијање вредности (get)
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public int getGodine() { return godine; }

    // Методи за постављање вредности (set)
    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public void setGodine(int godine) {
        this.godine = godine;
    }

    @Override
    public String toString() {
        return ime + " " + prezime
            + " (" + godine + ")";
    }

    // Тестирање
    public static void main(String[] args) {
        Primer01_OsobaZrno o1 =
            new Primer01_OsobaZrno();
        o1.setIme("Марко");
        o1.setPrezime("Марковић");
        o1.setGodine(22);
        System.out.println("Особа 1: " + o1);

        Primer01_OsobaZrno o2 =
            new Primer01_OsobaZrno(
                "Ана", "Јовановић", 21);
        System.out.println("Особа 2: " + o2);
    }
}
