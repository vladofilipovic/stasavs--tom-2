package rs.math.oop.g07.p02.deserijalizacija;

import java.io.*;

public class Primer02_Deserijalizacija {
    public static void main(String[] args) {
        // Десеријализација из датотеке
        try (ObjectInputStream ois =
                new ObjectInputStream(
                    new FileInputStream(
                        "studenti.ser"))) {
            Student s1 =
                (Student) ois.readObject();
            Student s2 =
                (Student) ois.readObject();

            System.out.println(
                "После десеријализације:");
            System.out.println("  " + s1);
            System.out.println("  " + s2);

        } catch (IOException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
