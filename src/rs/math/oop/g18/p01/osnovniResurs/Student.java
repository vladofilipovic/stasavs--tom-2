package rs.math.oop.g18.p01.osnovniResurs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Student {
    private Long id;
    private String ime;
    private String prezime;
    private String indeks;
    private Double prosek;
 
    public Student() {}
 
    public Student(Long id, String ime, String prezime,
        String indeks, Double prosek) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.prosek = prosek;
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
}
