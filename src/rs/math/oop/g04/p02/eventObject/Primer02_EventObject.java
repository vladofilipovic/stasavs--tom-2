package rs.math.oop.g04.p02.eventObject;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class Primer02_EventObject {

    static class PorukaEvent extends EventObject {
        private final String poruka;
        private final long vremeSlanja;

        public PorukaEvent(Object source, String poruka) {
            super(source);
            this.poruka = poruka;
            this.vremeSlanja = System.currentTimeMillis();
        }

        public String getPoruka() { return poruka; }
        public long getVremeSlanja() { return vremeSlanja; }
    }

    interface PorukaListener extends EventListener {
        void porukaPrimljena(PorukaEvent event);
    }

    static class Chat {
        private final String ime;
        private final List<PorukaListener> osluskivaci = new ArrayList<>();

        public Chat(String ime) { this.ime = ime; }

        public void dodajOsluskivac(PorukaListener l) {
            osluskivaci.add(l);
        }

        public void posaljiPoruku(String tekst) {
            PorukaEvent event = new PorukaEvent(this, tekst);
            for (PorukaListener l : osluskivaci) {
                l.porukaPrimljena(event);
            }
        }

        @Override
        public String toString() { return ime; }
    }

    public static void main(String[] args) {
        Chat chat = new Chat("Grupni chat");

        chat.dodajOsluskivac(event -> {
            System.out.printf("[%s] Poruka: %s%n",
                event.getSource(), event.getPoruka());
        });

        chat.dodajOsluskivac(new PorukaListener() {
            private int brojac = 0;
            @Override
            public void porukaPrimljena(PorukaEvent event) {
                brojac++;
                System.out.printf("  (Ukupno poruka: %d)%n", brojac);
            }
        });

        chat.posaljiPoruku("Zdravo svima!");
        chat.posaljiPoruku("Kako ste?");
        chat.posaljiPoruku("Java eventi su korisni.");
    }
}
