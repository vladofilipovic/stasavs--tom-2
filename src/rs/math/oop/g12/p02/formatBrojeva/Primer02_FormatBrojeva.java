package rs.math.oop.g12.p02.formatBrojeva;

import java.text.NumberFormat;
import java.util.Locale;

public class Primer02_FormatBrojeva {
    public static void main(String[] args) {
        double broj = 1234567.89;
 
        // Форматирање за различите локалитете
        Locale[] lokali = {
            new Locale("sr", "RS"),
            Locale.US,
            Locale.GERMANY,
            Locale.FRANCE
        };
 
        for (Locale lok : lokali) {
            NumberFormat nf =
            NumberFormat.getInstance(lok);
            System.out.println(
            lok + ": " + nf.format(broj));
        }
 
        // Парсирање броја из стринга
        try {
            NumberFormat srFormat =
            NumberFormat.getInstance(
                new Locale("sr", "RS"));
            Number parsiran =
            srFormat.parse("1.234.567,89");
            System.out.println(
            "Парсирано: "
            + parsiran.doubleValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
