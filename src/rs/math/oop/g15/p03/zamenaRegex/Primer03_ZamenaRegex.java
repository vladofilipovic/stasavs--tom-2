package rs.math.oop.g15.p03.zamenaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer03_ZamenaRegex {

    public static void main(String[] args) {
        // Замена формата датума
        String tekst = "Рођен: 15.03.1990, " +
            "запослен: 01.09.2015";
        String rezultat = tekst.replaceAll(
            "(\\d{2})\\.(\\d{2})\\.(\\d{4})",
            "$3-$2-$1");
        System.out.println("Оригинал:  " + tekst);
        System.out.println("ISO формат: " + rezultat);

        // Уклањање вишеструких размака
        String neuredan = "Ово\tје\tнеуредан   текст.";
        String uredan = neuredan.replaceAll("\\s+", " ");
        System.out.println("\nНеуредан: " + neuredan);
        System.out.println("Уредан:   " + uredan);

        // Маскирање бројева кредитних картица
        String kartice = "Картице: 4111-1111-1111-1111 " +
            "и 5500-0000-0000-0004";
        String maskirano = kartice.replaceAll(
            "(\\d{4})-\\d{4}-\\d{4}-(\\d{4})",
            "$1-****-****-$2");
        System.out.println("\nОригинал:  " + kartice);
        System.out.println("Маскирано: " + maskirano);

        // Динамичка замена помоћу Matcher-а
        String sablon = "Цена: $100, попуст: $25";
        Pattern dolarObrazac = Pattern.compile(
            "\\$(\\d+)");
        Matcher m = dolarObrazac.matcher(sablon);

        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            int iznos = Integer.parseInt(m.group(1));
            // Конверзија у динаре (1 USD = 108 RSD)
            m.appendReplacement(sb,
                (iznos * 108) + " дин");
        }
        m.appendTail(sb);
        System.out.println("\nОригинал: " + sablon);
        System.out.println("У динарима: " + sb);
    }
}
