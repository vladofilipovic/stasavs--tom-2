package rs.math.oop.g12.p03.valute;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Primer03_Valute {
    public static void main(String[] args) {
        double iznos = 1234.50;

        Locale[] lokali = {
            new Locale("sr", "RS"),
            Locale.US,
            Locale.GERMANY
        };

        for (Locale lok : lokali) {
            NumberFormat vf =
            NumberFormat.getCurrencyInstance(
                lok);
            System.out.println(
            lok + ": " + vf.format(iznos));
        }

        // Информације о валути
        Currency rsd = Currency.getInstance(
        new Locale("sr", "RS"));
        System.out.println(
        "Код: " + rsd.getCurrencyCode());
        System.out.println(
        "Симбол: " + rsd.getSymbol(
            new Locale("sr", "RS")));
    }
}
