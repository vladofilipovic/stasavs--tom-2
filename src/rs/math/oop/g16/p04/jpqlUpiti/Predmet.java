package rs.math.oop.g16.p04.jpqlUpiti;

import jakarta.persistence.*;

@Entity(name = "PredmetP04")
@Table(name = "predmet_p04")
class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private int espb;

    @ManyToOne
    @JoinColumn(name = "departman_id")
    private Departman departman;

    public Predmet() {}

    public Long getId() { return id; }
    public String getNaziv() { return naziv; }
    public int getEspb() { return espb; }
    public Departman getDepartman() { return departman; }
    public void setDepartman(Departman d) { this.departman = d; }
}
