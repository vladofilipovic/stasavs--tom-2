package rs.math.oop.g15.p02.grupeRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer02_GrupeRegex {

    public static void main(String[] args) {
        // Издвајање делова датума
        String tekst = "Датуми: 15.03.2024, 01.12.2023, " +
            "28.02.2025";

        Pattern datumObrazac = Pattern.compile(
            "(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher m = datumObrazac.matcher(tekst);

        System.out.println("Пронађени датуми:");
        while (m.find()) {
            System.out.printf("  %s – дан: %s, " +
                "месец: %s, година: %s%n",
                m.group(),
                m.group(1),
                m.group(2),
                m.group(3));
        }

        // Именоване групе
        String emailTekst = "Контакт: petar@matf.bg.ac.rs " +
            "и ana.m@gmail.com";

        Pattern emailObrazac = Pattern.compile(
            "(?<korisnik>[\\w.]+)@" +
            "(?<domen>[\\w.]+)");
        m = emailObrazac.matcher(emailTekst);

        System.out.println("\nПронађене адресе:");
        while (m.find()) {
            System.out.printf("  %s – корисник: %s, " +
                "домен: %s%n",
                m.group(),
                m.group("korisnik"),
                m.group("domen"));
        }

        // Повратне референце
        String html = "<b>подебљано</b> и <i>курзив</i>";
        Pattern htmlObrazac = Pattern.compile(
            "<(b|i)>(.*?)</\\1>");
        m = htmlObrazac.matcher(html);

        System.out.println("\nHTML елементи:");
        while (m.find()) {
            System.out.printf("  Ознака: %s, " +
                "садржај: %s%n",
                m.group(1), m.group(2));
        }
    }
}
