package rs.math.oop.g04.p01.osnovniDogadjaji;

import java.util.ArrayList;
import java.util.List;

public class Primer01_OsnovniDogadjaji {

    interface TemperatureListener {
        void onTemperatureChanged(double oldTemp, double newTemp);
    }

    static class Termometar {
        private double temperatura;
        private List<TemperatureListener> osluskivaci = new ArrayList<>();

        public void dodajOsluskivac(TemperatureListener l) {
            osluskivaci.add(l);
        }

        public void ukloniOsluskivac(TemperatureListener l) {
            osluskivaci.remove(l);
        }

        public void setTemperatura(double temp) {
            double stara = this.temperatura;
            this.temperatura = temp;
            for (TemperatureListener l : osluskivaci) {
                l.onTemperatureChanged(stara, temp);
            }
        }

        public double getTemperatura() { return temperatura; }
    }

    public static void main(String[] args) {
        Termometar termometar = new Termometar();

        // Osluskivac 1: anonimna klasa
        termometar.dodajOsluskivac(new TemperatureListener() {
            @Override
            public void onTemperatureChanged(double stara, double nova) {
                System.out.printf("Ispis: temperatura %.1f -> %.1f%n",
                    stara, nova);
            }
        });

        // Osluskivac 2: lambda za upozorenje
        termometar.dodajOsluskivac((stara, nova) -> {
            if (nova > 30.0) {
                System.out.printf("UPOZORENJE: visoka temperatura (%.1f)%n",
                    nova);
            }
        });

        // Osluskivac 3: lambda za detekciju naglog skoka
        termometar.dodajOsluskivac((stara, nova) -> {
            double razlika = nova - stara;
            if (Math.abs(razlika) > 5.0) {
                System.out.printf("Nagli skok: %.1f stepeni%n", razlika);
            }
        });

        System.out.println("--- Postavljanje temperature na 22.0 ---");
        termometar.setTemperatura(22.0);
        System.out.println("\n--- Postavljanje temperature na 28.5 ---");
        termometar.setTemperatura(28.5);
        System.out.println("\n--- Postavljanje temperature na 35.0 ---");
        termometar.setTemperatura(35.0);
    }
}
