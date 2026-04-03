package rs.math.oop.g08.p02.vezanaOsobina;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Primer02_VezanaOsobina {
    public static void main(String[] args) {
        TemperaturaZrno termometar =
            new TemperaturaZrno();

        // Регистрација ослушкивача
        termometar.addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(
                        PropertyChangeEvent e) {
                    System.out.println(
                        "Особина '"
                        + e.getPropertyName()
                        + "' промењена: "
                        + e.getOldValue()
                        + " -> " + e.getNewValue());
                }
            });

        // Промена вредности
        termometar.setTemperatura(20.5);
        termometar.setTemperatura(25.0);
        termometar.setTemperatura(18.3);
    }
}
