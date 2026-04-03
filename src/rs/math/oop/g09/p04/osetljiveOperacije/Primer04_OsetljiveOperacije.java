package rs.math.oop.g09.p04.osetljiveOperacije;

import java.util.logging.*;

public class Primer04_OsetljiveOperacije {
    private static final Logger dnevnik =
        Logger.getLogger("Безбедност");

    // Симулација провере корисника
    static boolean proveriKorisnika(
            String ime, String lozinka) {
        dnevnik.info("Покушај пријаве: " + ime);
        boolean uspeh =
            "admin".equals(ime)
            && "tajno".equals(lozinka);
        if (uspeh) {
            dnevnik.info(
                "Успешна пријава: " + ime);
        } else {
            dnevnik.warning(
                "Неуспешна пријава: " + ime);
        }
        return uspeh;
    }

    // Симулација приступа ресурсу
    static void pristupiResursu(
            String korisnik, String resurs) {
        dnevnik.info("Корисник " + korisnik
            + " приступа ресурсу: " + resurs);
        if ("тајни_подаци".equals(resurs)) {
            dnevnik.warning(
                "Приступ осетљивом ресурсу: "
                + resurs + " (корисник: "
                + korisnik + ")");
        }
        dnevnik.fine("Приступ одобрен за: "
            + resurs);
    }

    public static void main(String[] args) {
        // Подешавање дневника
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        dnevnik.addHandler(ch);
        dnevnik.setLevel(Level.ALL);
        dnevnik.setUseParentHandlers(false);

        // Симулација операција
        proveriKorisnika("admin", "tajno");
        proveriKorisnika("haker", "pokusaj");

        pristupiResursu("admin", "извештај");
        pristupiResursu("admin",
            "тајни_подаци");
    }
}
