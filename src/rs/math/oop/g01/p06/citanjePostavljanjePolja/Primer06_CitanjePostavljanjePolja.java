package rs.math.oop.g01.p06.citanjePostavljanjePolja;

import java.lang.reflect.Field;

public class Primer06_CitanjePostavljanjePolja {
    public static void main(String[] args) throws Exception {
        Student student = new Student("Марко Илић", 243, 8.5);
        System.out.println("Пре измене: " + student);

        Class klasa = student.getClass();

        // Читање приватног поља
        Field poljeIme = klasa.getDeclaredField("ime");
        poljeIme.setAccessible(true);
        String ime = (String) poljeIme.get(student);
        System.out.println("Прочитано име: " + ime);

        // Постављање нове вредности
        poljeIme.set(student, "Ана Сарић");

        // Измена нумеричког поља
        Field poljeProsek = klasa.getDeclaredField("prosek");
        poljeProsek.setAccessible(true);
        poljeProsek.setDouble(student, 9.2);

        System.out.println("После измене: " + student);
    }
}
