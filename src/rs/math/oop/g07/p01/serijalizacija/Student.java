package rs.math.oop.g07.p01.serijalizacija;

import java.io.*;

class Student implements Serializable {
    // Идентификатор верзије серијализације
    private static final long serialVersionUID = 1L;
    private String ime;
    private String prezime;
    private double prosek;
    // Поље означено као transient се не серијализује
    private transient String lozinka;

    public Student(String ime, String prezime,
            double prosek, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.prosek = prosek;
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ime + " " + prezime
            + " (просек: " + prosek
            + ", лозинка: " + lozinka + ")";
    }
}
