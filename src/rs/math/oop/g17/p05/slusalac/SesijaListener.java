package rs.math.oop.g17.p05.slusalac;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SesijaListener implements HttpSessionListener {
 
    private static final AtomicInteger aktivneSesije =
        new AtomicInteger(0);
 
    @Override
    public void sessionCreated(HttpSessionEvent dogadjaj) {
        int broj = aktivneSesije.incrementAndGet();
        System.out.println("Нова сесија: " +
            dogadjaj.getSession().getId());
        System.out.println("Активних сесија: " + broj);
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent dogadjaj) {
        int broj = aktivneSesije.decrementAndGet();
        System.out.println("Сесија уништена: " +
            dogadjaj.getSession().getId());
        System.out.println("Активних сесија: " + broj);
    }
 
    public static int getBrojAktivnihSesija() {
        return aktivneSesije.get();
    }
}
