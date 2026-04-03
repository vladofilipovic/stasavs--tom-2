package rs.math.oop.g07.p05.jsonJacksonSerijalizacija;

class Knjiga {
    private String naslov;
    private String autor;
    private int godinaIzdanja;

    public Knjiga() {}

    public Knjiga(String naslov, String autor,
            int godinaIzdanja) {
        this.naslov = naslov;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
    }

    public String getNaslov() { return naslov; }
    public void setNaslov(String naslov) { this.naslov = naslov; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getGodinaIzdanja() { return godinaIzdanja; }
    public void setGodinaIzdanja(int g) { this.godinaIzdanja = g; }

    @Override
    public String toString() {
        return naslov + " - " + autor + " (" + godinaIzdanja + ")";
    }
}
