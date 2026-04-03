package rs.math.oop.g16.p05.criteriaApi;

import jakarta.persistence.*;

@Entity(name = "StudentP05")
@Table(name = "student_p05")
class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String indeks;
    private double prosek;

    @Enumerated(EnumType.STRING)
    private StatusStudenta status;

    public Student() {}

    public Long getId() { return id; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public String getIndeks() { return indeks; }
    public double getProsek() { return prosek; }
    public StatusStudenta getStatus() { return status; }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + indeks + ") - " +
        String.format("%.2f", prosek);
    }
}
