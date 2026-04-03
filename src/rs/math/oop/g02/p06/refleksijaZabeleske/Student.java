package rs.math.oop.g02.p06.refleksijaZabeleske;

class Student {
    @Obavezno(poruka = "Име студента је обавезно")
    @Duzina(min = 2, max = 50, poruka = "Име мора имати 2-50 карактера")
    @Prikazivo(naziv = "Име", redosled = 1)
    private String ime;

    @Obavezno
    @Duzina(min = 4, max = 15, poruka = "Индекс мора имати 4-15 карактера")
    @Prikazivo(naziv = "Број индекса", redosled = 2)
    private String indeks;

    @Opseg(min = 6.0, max = 10.0, poruka = "Просек мора бити између 6.0 и 10.0")
    @Prikazivo(naziv = "Просечна оцена", redosled = 3)
    private double prosek;

    @Opseg(min = 0, max = 300, poruka = "ЕСПБ мора бити између 0 и 300")
    @Prikazivo(naziv = "ЕСПБ бодови", redosled = 4)
    private int espb;

    public Student(String ime, String indeks, double prosek, int espb) {
        this.ime = ime;
        this.indeks = indeks;
        this.prosek = prosek;
        this.espb = espb;
    }
}
