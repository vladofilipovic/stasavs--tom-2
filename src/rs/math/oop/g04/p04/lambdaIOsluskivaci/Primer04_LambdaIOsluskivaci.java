package rs.math.oop.g04.p04.lambdaIOsluskivaci;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Primer04_LambdaIOsluskivaci {

    static class Narudzbina {
        private final String artikal;
        private final double cena;
        private final int kolicina;

        public Narudzbina(String artikal, double cena, int kolicina) {
            this.artikal = artikal;
            this.cena = cena;
            this.kolicina = kolicina;
        }

        public String getArtikal() { return artikal; }
        public double getCena() { return cena; }
        public int getKolicina() { return kolicina; }
        public double getUkupno() { return cena * kolicina; }

        @Override
        public String toString() {
            return String.format("%s (%.2f x %d = %.2f)",
                artikal, cena, kolicina, getUkupno());
        }
    }

    static class Prodavnica {
        private final List<Consumer<Narudzbina>> osluskivaci
            = new ArrayList<>();
        private final List<FilteredHandler> filtriraniOsluskivaci
            = new ArrayList<>();

        public void dodajOsluskivac(Consumer<Narudzbina> handler) {
            osluskivaci.add(handler);
        }

        public void dodajFiltriraniOsluskivac(
                Predicate<Narudzbina> filter,
                Consumer<Narudzbina> handler) {
            filtriraniOsluskivaci.add(
                new FilteredHandler(filter, handler));
        }

        public void primiNarudzbinu(Narudzbina n) {
            System.out.println("Nova narudzbina: " + n);
            osluskivaci.forEach(l -> l.accept(n));
            for (FilteredHandler fh : filtriraniOsluskivaci) {
                if (fh.filter.test(n)) {
                    fh.handler.accept(n);
                }
            }
            System.out.println();
        }

        private static class FilteredHandler {
            final Predicate<Narudzbina> filter;
            final Consumer<Narudzbina> handler;
            FilteredHandler(Predicate<Narudzbina> f,
                            Consumer<Narudzbina> h) {
                this.filter = f;
                this.handler = h;
            }
        }
    }

    static void zapisiULog(Narudzbina n) {
        System.out.println(
            "  [LOG] Zapisana narudzbina: " + n.getArtikal());
    }

    static void posaljiPotvrdu(Narudzbina n) {
        System.out.println(
            "  [EMAIL] Potvrda za: " + n.getArtikal());
    }

    public static void main(String[] args) {
        Prodavnica prodavnica = new Prodavnica();

        // Lambda kao osluskivac
        prodavnica.dodajOsluskivac(n ->
            System.out.println(
                "  Obrada narudzbine: " + n.getArtikal()));

        // Reference na metode kao osluskivaci
        prodavnica.dodajOsluskivac(
            Primer04_LambdaIOsluskivaci::zapisiULog);
        prodavnica.dodajOsluskivac(
            Primer04_LambdaIOsluskivaci::posaljiPotvrdu);

        // Filtrirani: samo za skupe narudzbine
        prodavnica.dodajFiltriraniOsluskivac(
            n -> n.getUkupno() > 5000,
            n -> System.out.printf(
                "  [UPOZORENJE] Velika narudzbina: %.2f%n",
                n.getUkupno()));

        // Filtrirani: samo za elektroniku
        prodavnica.dodajFiltriraniOsluskivac(
            n -> n.getArtikal().startsWith("Laptop") ||
                 n.getArtikal().startsWith("Telefon"),
            n -> System.out.println(
                "  [GARANCIJA] Potrebna garancija za: "
                + n.getArtikal()));

        prodavnica.primiNarudzbinu(
            new Narudzbina("Knjiga", 1500, 2));
        prodavnica.primiNarudzbinu(
            new Narudzbina("Laptop", 120000, 1));
        prodavnica.primiNarudzbinu(
            new Narudzbina("Telefon", 45000, 3));
    }
}
