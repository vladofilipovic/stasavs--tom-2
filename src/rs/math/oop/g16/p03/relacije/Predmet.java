package rs.math.oop.g16.p03.relacije;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PredmetP03")
@Table(name = "predmet_p03")
public class Predmet {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String naziv;
 
    private int espb;
 
    // Више предмета припада једном департману
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departman_id")
    private Departman departman;
 
    // Више студената може слушати више предмета
    @ManyToMany(mappedBy = "predmeti")
    private List<Student> studenti = new ArrayList<>();
 
    public Predmet() {}
    public Predmet(String naziv, int espb) {
        this.naziv = naziv;
        this.espb = espb;
    }
 
    // Методи за приступање и постављање вредности...
    public Long getId() { return id; }
    public String getNaziv() { return naziv; }
    public int getEspb() { return espb; }
    public Departman getDepartman() { return departman; }
    public void setDepartman(Departman d) {
        this.departman = d;
    }
    public List<Student> getStudenti() { return studenti; }
}
