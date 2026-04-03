package rs.math.oop.g16.p03.relacije;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "DepartmanP03")
@Table(name = "departman_p03")
public class Departman {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String naziv;
 
    // Један департман има више предмета
    @OneToMany(mappedBy = "departman",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private List<Predmet> predmeti = new ArrayList<>();
 
    public Departman() {}
    public Departman(String naziv) { this.naziv = naziv; }
 
    public void dodajPredmet(Predmet p) {
        predmeti.add(p);
        p.setDepartman(this);
    }
 
    // Методи за приступање и постављање вредности...
    public Long getId() { return id; }
    public String getNaziv() { return naziv; }
    public List<Predmet> getPredmeti() { return predmeti; }
}
