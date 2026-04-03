package rs.math.oop.g12.p05.sortiranje;

import java.text.Collator;
import java.util.*;

public class Primer05_Sortiranje {
    public static void main(String[] args) {
        List imena = Arrays.asList(
        "Чедомир", "Ђорђе", "Андреј",
        "Жарко", "Бранко", "Ћирило",
        "Дејан", "Шарко");
 
        // Сортирање без локалитета
        List kopija1 =
        new ArrayList<>(imena);
        Collections.sort(kopija1);
        System.out.println(
        "Без локалитета: " + kopija1);
 
        // Сортирање са српским локалитетом
        Collator srpski = Collator.getInstance(
        new Locale("sr", "RS"));
        List kopija2 =
        new ArrayList<>(imena);
        kopija2.sort(srpski);
        System.out.println(
        "Српски:     " + kopija2);
 
        // Подешавање осетљивости
        srpski.setStrength(Collator.PRIMARY);
        System.out.println(
        "а == А? "
        + (srpski.compare("а", "А") == 0));
    }
}
