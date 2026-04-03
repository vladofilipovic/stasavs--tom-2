package rs.math.oop.g12.p01.lokaliteti;

import java.util.Locale;

public class Primer01_Lokaliteti {
    public static void main(String[] args) {
        // Подразумевани локалитет
        Locale podrazumevani = Locale.getDefault();
        System.out.println(
        "Подразумевани: " + podrazumevani);
 
        // Унапред дефинисани локалитети
        System.out.println(
        "САД: " + Locale.US);
        System.out.println(
        "Француска: " + Locale.FRANCE);
 
        // Креирање локалитета
        Locale srpski =
        new Locale("sr", "RS");
        System.out.println(
        "Српски: " + srpski);
        System.out.println(
        "Језик: " + srpski.getDisplayLanguage(
            srpski));
        System.out.println(
        "Земља: " + srpski.getDisplayCountry(
            srpski));
 
        // Сви доступни локалитети
        Locale[] svi = Locale.getAvailableLocales();
        System.out.println(
        "Број локалитета: " + svi.length);
    }
}
