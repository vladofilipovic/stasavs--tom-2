package rs.math.oop.g02.p04.kreiranjeZabeleski;

@InfoKlase(
naziv = "Калкулатор",
autori = {"Марко Илић", "Ана Сарић"},
datumKreiranja = "2024-01-15"
)
class Kalkulator {

    @Opseg(min = -1000, max = 1000, poruka = "Број мора бити у опсегу [-1000, 1000]")
    private double vrednost;

    public Kalkulator(double vrednost) {
        this.vrednost = vrednost;
    }

    @Test(opis = "Тестира сабирање", prioritet = 1)
    public double saberi(double b) { return vrednost + b; }

    @Test(opis = "Тестира одузимање", prioritet = 1)
    public double oduzmi(double b) { return vrednost - b; }

    @Test(opis = "Тестира дељење", prioritet = 2)
    public double podeli(double b) {
        if (b == 0) throw new ArithmeticException("Дељење нулом");
        return vrednost / b;
    }

    @Test(opis = "Застарео тест", preskoci = true)
    public double stariMetod() { return vrednost; }
}
