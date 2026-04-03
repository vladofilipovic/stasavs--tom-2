package rs.math.oop.g14.p07.dao;


public class Student {
    private int id;
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
 
    // Методи за приступање и постављање вредности
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }
    public String getPrezime() { return prezime; }
    public void setPrezime(String p) { this.prezime = p; }
    public String getIndeks() { return indeks; }
    public void setIndeks(String i) { this.indeks = i; }
    public double getProsek() { return prosek; }
    public void setProsek(double p) { this.prosek = p; }
 
    @Override
    public String toString() {
        return String.format("%s %s (%s) – %.2f",
            ime, prezime, indeks, prosek);
    }
}
