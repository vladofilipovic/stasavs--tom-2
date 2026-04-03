package rs.math.oop.g07.p01.serijalizacija;

import java.io.*;

public class Primer01_Serijalizacija {
    public static void main(String[] args) {
        Student s1 = new Student(
            "Марко", "Марковић", 9.5, "тајна123");
        Student s2 = new Student(
            "Ана", "Јовановић", 9.8, "сигурна456");

        // Серијализација у датотеку
        try (ObjectOutputStream oos =
                new ObjectOutputStream(
                    new FileOutputStream(
                        "studenti.ser"))) {
            oos.writeObject(s1);
            oos.writeObject(s2);
            System.out.println(
                "Објекти су серијализовани.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Пре серијализације:");
        System.out.println("  " + s1);
        System.out.println("  " + s2);
    }
}
