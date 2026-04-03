package rs.math.oop.g15.p04.podelaRegex;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Primer04_PodelaRegex {

    public static void main(String[] args) {
        // Подела по различитим разделницима
        String csv = "Марко,Јелена,,Никола,Ана";
        String[] imena = csv.split(",");
        System.out.println("CSV подела: " +
            Arrays.toString(imena));
        System.out.println("Број елемената: " +
            imena.length);

        // Подела по више разделника
        String mesovit = "јабука;крушка,шљива банана:грожђе";
        String[] voce = mesovit.split("[;,:\\s]+");
        System.out.println("\nВише разделника: " +
            Arrays.toString(voce));

        // Ограничавање броја делова
        String putanja = "/home/korisnik/dokumenti/fajl.txt";
        String[] delovi = putanja.split("/", 4);
        System.out.println("\nПутања (макс 4 дела): " +
            Arrays.toString(delovi));

        // Подела реченице на речи
        String recenica = "Ово је пример  реченице.";
        String[] reci = recenica.trim().split("\\s+");
        System.out.println("\nРечи: " +
            Arrays.toString(reci));
        System.out.println("Број речи: " + reci.length);

        // Подела по регуларном изразу
        String jednacina = "3+5-2*8/4";
        String[] brojevi = jednacina.split("[+\\-*/]");
        System.out.println("\nБројеви: " +
            Arrays.toString(brojevi));

        // Подела помоћу Pattern
        Pattern p = Pattern.compile("\\d+");
        String[] operatori = p.split(jednacina);
        System.out.println("Оператори: " +
            Arrays.toString(operatori));
    }
}
