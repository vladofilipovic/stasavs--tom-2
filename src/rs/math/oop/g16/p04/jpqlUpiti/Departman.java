package rs.math.oop.g16.p04.jpqlUpiti;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "DepartmanP04")
@Table(name = "departman_p04")
class Departman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "departman",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private List<Predmet> predmeti = new ArrayList<>();

    public Departman() {}

    public Long getId() { return id; }
    public String getNaziv() { return naziv; }
    public List<Predmet> getPredmeti() { return predmeti; }
}
