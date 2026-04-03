package rs.math.oop.g07.p04.xmlSerijalizacija;

import java.beans.*;
import java.io.*;

public class Primer04_XmlSerijalizacija {
    public static void main(String[] args)
            throws Exception {
        Knjiga k1 = new Knjiga(
            "Мислити на Јави", "Bruce Eckel", 2006);
        Knjiga k2 = new Knjiga(
            "Ефективна Јава", "Joshua Bloch", 2018);

        // XML серијализација
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                    new FileOutputStream(
                        "knjige.xml")))) {
            encoder.writeObject(k1);
            encoder.writeObject(k2);
            System.out.println(
                "Објекти серијализовани у XML.");
        }

        // XML десеријализација
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                    new FileInputStream(
                        "knjige.xml")))) {
            Knjiga ucitana1 =
                (Knjiga) decoder.readObject();
            Knjiga ucitana2 =
                (Knjiga) decoder.readObject();

            System.out.println(
                "Десеријализовано из XML:");
            System.out.println("  " + ucitana1);
            System.out.println("  " + ucitana2);
        }
    }
}
