package rs.math.oop.g16.p01.mapiranjeEntiteta;

import jakarta.persistence.*;

@Entity(name = "StudentP01")
@Table(name = "student_p01")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "ime", nullable = false, length = 50)
    private String ime;
 
    @Column(name = "prezime", nullable = false, length = 50)
    private String prezime;
 
    @Column(unique = true, length = 20)
    private String indeks;
 
    @Column
    private Double prosek;
 
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusStudenta status;
 
    // Подразумевани конструктор (обавезан за JPA)
    public Student() {}
 
    public Student(String ime, String prezime,
        String indeks, Double prosek) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.prosek = prosek;
        this.status = StatusStudenta.AKTIVAN;
    }
 
    // Методи за приступање и постављање вредности
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }
    public String getPrezime() { return prezime; }
    public void setPrezime(String p) { this.prezime = p; }
    public String getIndeks() { return indeks; }
    public void setIndeks(String i) { this.indeks = i; }
    public Double getProsek() { return prosek; }
    public void setProsek(Double p) { this.prosek = p; }
    public StatusStudenta getStatus() { return status; }
    public void setStatus(StatusStudenta s) {
        this.status = s;
    }
 
    @Override
    public String toString() {
        return String.format("%s %s (%s) – %.2f [%s]",
            ime, prezime, indeks, prosek, status);
    }
}
