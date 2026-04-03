package rs.math.oop.g08.p02.vezanaOsobina;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

class TemperaturaZrno implements Serializable {
    private static final long serialVersionUID = 1L;
    private double temperatura;

    // Подршка за обавештавање о промени
    private final PropertyChangeSupport podrska =
        new PropertyChangeSupport(this);

    public TemperaturaZrno() {
        this.temperatura = 0.0;
    }

    // Метод за добијање вредности
    public double getTemperatura() {
        return temperatura;
    }

    // Метод за постављање вредности
    // са обавештавањем ослушкивача
    public void setTemperatura(double novaVrednost) {
        double staraVrednost = this.temperatura;
        this.temperatura = novaVrednost;
        // Обавештавање о промени
        podrska.firePropertyChange(
            "temperatura", staraVrednost,
            novaVrednost);
    }

    // Регистрација ослушкивача
    public void addPropertyChangeListener(
            PropertyChangeListener l) {
        podrska.addPropertyChangeListener(l);
    }

    // Уклањање ослушкивача
    public void removePropertyChangeListener(
            PropertyChangeListener l) {
        podrska.removePropertyChangeListener(l);
    }
}
