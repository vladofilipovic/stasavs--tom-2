package rs.math.oop.g15.p06.prakticniRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer06_PrakticniRegex {

    // Валидација email адресе
    static boolean jeValidanEmail(String email) {
        return Pattern.matches(
        "[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}", email);
    }

    // Валидација ЈМБГ-а (13 цифара)
    static boolean jeValidanJMBG(String jmbg) {
        return Pattern.matches("\\d{13}", jmbg);
    }

    // Валидација лозинке
    // (мин 8 знакова, велико слово, мало слово, цифра)
    static boolean jeJakaLozinka(String lozinka) {
        return lozinka.length() >= 8 &&
        Pattern.compile("[A-Z]").matcher(lozinka).find() &&
        Pattern.compile("[a-z]").matcher(lozinka).find() &&
        Pattern.compile("\\d").matcher(lozinka).find();
    }

    // Издвајање URL-ова из текста
    static void izdvojiURLove(String tekst) {
        Pattern urlObrazac = Pattern.compile(
        "https?://[\\w.-]+(?:/[\\w./?&=%+-]*)?");
        Matcher m = urlObrazac.matcher(tekst);
        while (m.find()) {
            System.out.println("  " + m.group());
        }
    }

    public static void main(String[] args) {
        // Валидација email адреса
        String[] emailovi = {
            "korisnik@domen.com",
            "ime.prezime@firma.rs",
            "nevalidan@",
            "@bezimena.com"
        };
        System.out.println("Валидација email адреса:");
        for (String e : emailovi) {
            System.out.printf("  %-25s %s%n", e,
                jeValidanEmail(e) ? "✓" : "✗");
        }

        // Валидација лозинки
        String[] lozinke = {
            "Abc12345", "abcdefgh",
            "ABCDEFGH", "Ab1"
        };
        System.out.println("\nВалидација лозинки:");
        for (String l : lozinke) {
            System.out.printf("  %-15s %s%n", l,
                jeJakaLozinka(l) ? "јака" : "слаба");
        }

        // Издвајање URL-ова
        String tekst = "Посетите https://matf.bg.ac.rs " +
            "или http://www.example.com/stranica?id=5 " +
            "за више информација.";
        System.out.println("\nПронађени URL-ови:");
        izdvojiURLove(tekst);

        // Чишћење HTML ознака
        String html = "<p>Ово је <b>подебљан</b> и " +
            "<i>искошен</i> текст.</p>";
        String cistTekst = html.replaceAll("<[^>]+>", "");
        System.out.println("\nHTML: " + html);
        System.out.println("Чист: " + cistTekst);
    }
}
