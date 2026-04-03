package rs.math.oop.g08.p03.ogranicenaOsobina;

import java.beans.*;
import java.io.Serializable;

class OcenaZrno implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ocena;

    private final VetoableChangeSupport veto =
        new VetoableChangeSupport(this);
    private final PropertyChangeSupport podrska =
        new PropertyChangeSupport(this);

    public OcenaZrno() { this.ocena = 5; }

    public int getOcena() { return ocena; }

    public void setOcena(int novaOcena)
            throws PropertyVetoException {
        int staraOcena = this.ocena;
        // Проверавамо да ли ослушкивачи одобравају
        veto.fireVetoableChange(
            "ocena", staraOcena, novaOcena);
        // Ако нема вета, постављамо нову вредност
        this.ocena = novaOcena;
        podrska.firePropertyChange(
            "ocena", staraOcena, novaOcena);
    }

    public void addVetoableChangeListener(
            VetoableChangeListener l) {
        veto.addVetoableChangeListener(l);
    }

    public void addPropertyChangeListener(
            PropertyChangeListener l) {
        podrska.addPropertyChangeListener(l);
    }
}
