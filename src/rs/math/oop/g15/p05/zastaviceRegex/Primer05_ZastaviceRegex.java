package rs.math.oop.g15.p05.zastaviceRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer05_ZastaviceRegex {

    public static void main(String[] args) {
        // Претраживање без разликовања величине слова
        String tekst = "Java је JAVA је jAvA";
        Pattern p1 = Pattern.compile("java",
            Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(tekst);

        System.out.println("Без разликовања величине:");
        while (m1.find()) {
            System.out.println("  " + m1.group() +
                " на позицији " + m1.start());
        }

        // Вишелинијски режим
        String viseLinija = "Први ред\nДруги ред\nТрећи ред";
        Pattern p2 = Pattern.compile("^\\w+",
            Pattern.MULTILINE |
            Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m2 = p2.matcher(viseLinija);

        System.out.println("\nПрве речи сваког реда:");
        while (m2.find()) {
            System.out.println("  " + m2.group());
        }

        // Уникод подршка
        String cirilica = "Здраво Свете 123";
        Pattern p3 = Pattern.compile("\\w+",
            Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m3 = p3.matcher(cirilica);

        System.out.println("\nУникод речи:");
        while (m3.find()) {
            System.out.println("  " + m3.group());
        }

        // Без Уникод подршке
        Pattern p4 = Pattern.compile("\\w+");
        Matcher m4 = p4.matcher(cirilica);

        System.out.println("\nБез Уникод подршке:");
        while (m4.find()) {
            System.out.println("  " + m4.group());
        }
    }
}
