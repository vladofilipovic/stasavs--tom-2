package rs.math.oop.g04.p05.lanacDogadjaja;

import java.util.ArrayList;
import java.util.List;

public class Primer05_LanacDogadjaja {

    static class Dogadjaj {
        private final String tip;
        private final String poruka;
        private boolean obradjen = false;

        public Dogadjaj(String tip, String poruka) {
            this.tip = tip;
            this.poruka = poruka;
        }

        public String getTip() { return tip; }
        public String getPoruka() { return poruka; }
        public boolean isObradjen() { return obradjen; }

        public void zaustavi() {
            this.obradjen = true;
            System.out.println(
                "[Propagacija zaustavljena]");
        }
    }

    interface ObradaDogadjaja {
        void obradi(Dogadjaj d);
    }

    static class Komponenta {
        private final String ime;
        private Komponenta roditelj;
        private final List<ObradaDogadjaja> obrade
            = new ArrayList<>();

        public Komponenta(String ime) { this.ime = ime; }

        public void setRoditelj(Komponenta roditelj) {
            this.roditelj = roditelj;
        }

        public void dodajObradu(ObradaDogadjaja obrada) {
            obrade.add(obrada);
        }

        public void emitujDogadjaj(Dogadjaj d) {
            System.out.printf("  [%s] Prima dogadjaj: %s%n",
                ime, d.getTip() + " - " + d.getPoruka());

            for (ObradaDogadjaja obrada : obrade) {
                obrada.obradi(d);
                if (d.isObradjen()) return;
            }

            if (roditelj != null && !d.isObradjen()) {
                System.out.printf(
                    "  [%s] Prosledjuje dogadjaj roditelju%n",
                    ime);
                roditelj.emitujDogadjaj(d);
            } else if (roditelj == null && !d.isObradjen()) {
                System.out.printf(
                    "  [%s] Dogadjaj nije obradjen (koren)%n",
                    ime);
            }
        }
    }

    public static void main(String[] args) {
        Komponenta aplikacija = new Komponenta("Aplikacija");
        Komponenta panel = new Komponenta("Panel");
        Komponenta dugme = new Komponenta("Dugme");

        dugme.setRoditelj(panel);
        panel.setRoditelj(aplikacija);

        aplikacija.dodajObradu(d -> {
            if ("GRESKA".equals(d.getTip())) {
                System.out.printf(
                    "[Aplikacija] Prijavljena greska: %s%n",
                    d.getPoruka());
                d.zaustavi();
            }
        });

        panel.dodajObradu(d -> {
            if ("KLIK".equals(d.getTip())) {
                System.out.printf(
                    "[Panel] Obradjen klik: %s%n",
                    d.getPoruka());
                d.zaustavi();
            }
        });

        dugme.dodajObradu(d ->
            System.out.printf(
                "[Dugme] Primljen dogadjaj tipa: %s%n",
                d.getTip()));

        System.out.println(
            "=== KLIK (zaustavljen na panelu) ===");
        dugme.emitujDogadjaj(
            new Dogadjaj("KLIK", "Levi klik misa"));

        System.out.println(
            "\n=== GRESKA (propagira do aplikacije) ===");
        dugme.emitujDogadjaj(
            new Dogadjaj("GRESKA", "Nepoznata akcija"));

        System.out.println(
            "\n=== INFO (neobradjeno) ===");
        dugme.emitujDogadjaj(
            new Dogadjaj("INFO", "Korisnik pristupio"));
    }
}
