package rs.math.oop.g08.p04.introspekcija;

import java.beans.*;
import java.io.Serializable;

class TemperaturaZrno implements Serializable {
    private static final long serialVersionUID = 1L;
    private double temperatura;

    private final PropertyChangeSupport podrska =
        new PropertyChangeSupport(this);

    public TemperaturaZrno() {
        this.temperatura = 0.0;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double novaVrednost) {
        double staraVrednost = this.temperatura;
        this.temperatura = novaVrednost;
        podrska.firePropertyChange(
            "temperatura", staraVrednost,
            novaVrednost);
    }

    public void addPropertyChangeListener(
            PropertyChangeListener l) {
        podrska.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(
            PropertyChangeListener l) {
        podrska.removePropertyChangeListener(l);
    }
}
