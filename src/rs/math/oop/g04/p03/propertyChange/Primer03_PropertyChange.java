package rs.math.oop.g04.p03.propertyChange;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Primer03_PropertyChange {

    static class Student {
        private String ime;
        private double prosek;
        private final PropertyChangeSupport podrska;

        public Student(String ime, double prosek) {
            this.ime = ime;
            this.prosek = prosek;
            this.podrska = new PropertyChangeSupport(this);
        }

        public void dodajOsluskivac(PropertyChangeListener l) {
            podrska.addPropertyChangeListener(l);
        }

        public void dodajOsluskivacZaSvojstvo(String svojstvo,
                                               PropertyChangeListener l) {
            podrska.addPropertyChangeListener(svojstvo, l);
        }

        public String getIme() { return ime; }

        public void setIme(String ime) {
            String staro = this.ime;
            this.ime = ime;
            podrska.firePropertyChange("ime", staro, ime);
        }

        public double getProsek() { return prosek; }

        public void setProsek(double prosek) {
            double stari = this.prosek;
            this.prosek = prosek;
            podrska.firePropertyChange("prosek", stari, prosek);
        }

        @Override
        public String toString() {
            return ime + " (prosek: " + prosek + ")";
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Marko", 8.5);

        // Opsti osluskivac - reaguje na sve promene
        student.dodajOsluskivac(event -> {
            System.out.printf("Promena svojstva '%s': %s -> %s%n",
                event.getPropertyName(),
                event.getOldValue(),
                event.getNewValue());
        });

        // Specijalizovani osluskivac - samo za prosek
        student.dodajOsluskivacZaSvojstvo("prosek", event -> {
            double noviProsek = (Double) event.getNewValue();
            if (noviProsek >= 9.0) {
                System.out.println(
                    "  >>> Cestitamo! Student je na budzetu.");
            } else if (noviProsek < 6.0) {
                System.out.println(
                    "  >>> Upozorenje: prosek ispod minimuma!");
            }
        });

        System.out.println("Pocetno stanje: " + student);
        System.out.println();

        student.setIme("Marko Petrovic");
        student.setProsek(9.2);
        student.setProsek(5.8);

        System.out.println("\nKrajnje stanje: " + student);
    }
}
