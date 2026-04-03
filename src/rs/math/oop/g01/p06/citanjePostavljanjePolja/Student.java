package rs.math.oop.g01.p06.citanjePostavljanjePolja;

import java.lang.reflect.Field;

class Student {
    private String ime;
    private int brojIndeksa;
    private double prosek;

    public Student(String ime, int brojIndeksa, double prosek) {
        this.ime = ime;
        this.brojIndeksa = brojIndeksa;
        this.prosek = prosek;
    }

    @Override
    public String toString() {
        return "Student{име='" + ime
                + "', бројИндекса=" + brojIndeksa
                + ", просек=" + prosek + "}";
    }
}
