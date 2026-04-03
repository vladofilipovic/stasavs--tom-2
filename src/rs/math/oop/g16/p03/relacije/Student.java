package rs.math.oop.g16.p03.relacije;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "StudentP03")
@Table(name = "student_p03")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String ime;
    private String prezime;
 
    // Студент може слушати више предмета
    @ManyToMany
    @JoinTable(
    name = "student_predmet",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "predmet_id")
    )
    private List<Predmet> predmeti = new ArrayList<>();
 
    public Student() {}
    public Student(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }
 
    public void upisiPredmet(Predmet p) {
        predmeti.add(p);
        p.getStudenti().add(this);
    }
 
    // Методи за приступање и постављање вредности...
    public Long getId() { return id; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public List<Predmet> getPredmeti() { return predmeti; }
}
