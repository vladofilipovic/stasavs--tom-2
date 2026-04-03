package rs.math.oop.g16.p02.crudOperacije;

import jakarta.persistence.*;

@Entity(name = "StudentP02")
@Table(name = "student_p02")
class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String indeks;
    private double prosek;

    public Student() {}

    public Student(String ime, String prezime,
        String indeks, double prosek) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.prosek = prosek;
    }

    public Long getId() { return id; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public String getIndeks() { return indeks; }
    public double getProsek() { return prosek; }
    public void setProsek(double prosek) { this.prosek = prosek; }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + indeks + ") - " +
        String.format("%.2f", prosek);
    }
}
