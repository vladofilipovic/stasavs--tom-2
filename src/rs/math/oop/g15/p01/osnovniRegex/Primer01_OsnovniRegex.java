package rs.math.oop.g15.p01.osnovniRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer01_OsnovniRegex {

    public static void main(String[] args) {
        String tekst = "Телефон: 011-1234567, " +
            "мобилни: 065-9876543, " +
            "факс: 011-7654321";

        // Образац за телефонски број (3 цифре-7 цифара)
        Pattern obrazac = Pattern.compile("\\d{3}-\\d{7}");
        Matcher pronalazac = obrazac.matcher(tekst);

        System.out.println("Пронађени бројеви:");
        while (pronalazac.find()) {
            System.out.println("  " + pronalazac.group() +
                " (позиција: " + pronalazac.start() +
                "-" + pronalazac.end() + ")");
        }

        // Провера целог поклапања
        String broj = "011-1234567";
        System.out.println("\n" + broj + " се поклапа: " +
            obrazac.matcher(broj).matches());

        String tekst2 = "abc-defghij";
        System.out.println(tekst2 + " се поклапа: " +
            obrazac.matcher(tekst2).matches());

        // Брзо поклапање без компајлирања
        boolean poklapa = Pattern.matches(
            "\\d{3}-\\d{7}", "065-1234567");
        System.out.println("\nБрзо поклапање: " + poklapa);
    }
}
