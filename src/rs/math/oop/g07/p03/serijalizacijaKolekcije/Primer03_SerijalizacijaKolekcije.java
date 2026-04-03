package rs.math.oop.g07.p03.serijalizacijaKolekcije;

import java.io.*;
import java.util.*;

public class Primer03_SerijalizacijaKolekcije {
    public static void main(String[] args)
            throws Exception {
        // Креирање листе студената
        List<Student> lista = new ArrayList<>();
        lista.add(new Student(
            "Марко", "Марковић", 9.5, ""));
        lista.add(new Student(
            "Ана", "Јовановић", 9.8, ""));
        lista.add(new Student(
            "Петар", "Петровић", 8.7, ""));

        // Серијализација листе
        try (ObjectOutputStream oos =
                new ObjectOutputStream(
                    new FileOutputStream(
                        "lista.ser"))) {
            oos.writeObject(lista);
            System.out.println(
                "Листа серијализована: "
                + lista.size() + " елемената");
        }

        // Десеријализација листе
        try (ObjectInputStream ois =
                new ObjectInputStream(
                    new FileInputStream(
                        "lista.ser"))) {
            @SuppressWarnings("unchecked")
            List<Student> ucitana =
                (List) ois.readObject();

            System.out.println(
                "Десеријализовано:");
            for (Student s : ucitana) {
                System.out.println("  " + s);
            }
        }
    }
}
