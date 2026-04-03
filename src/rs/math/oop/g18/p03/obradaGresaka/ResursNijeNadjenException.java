package rs.math.oop.g18.p03.obradaGresaka;


public class ResursNijeNadjenException
    extends RuntimeException {
    private final Long id;
 
    public ResursNijeNadjenException(Long id) {
        super("Ресурс са ID-јем " + id +
            " није пронађен");
        this.id = id;
    }
 
    public Long getId() { return id; }
}
