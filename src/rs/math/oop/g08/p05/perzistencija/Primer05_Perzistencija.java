package rs.math.oop.g08.p05.perzistencija;

import java.beans.*;
import java.io.*;

public class Primer05_Perzistencija {
    public static void main(String[] args)
            throws Exception {
        // Креирање и подешавање зрна
        OsobaZrno osoba =
            new OsobaZrno();
        osoba.setIme("Марко");
        osoba.setPrezime("Марковић");
        osoba.setGodine(22);

        // Чување у XML формату
        try (XMLEncoder enc = new XMLEncoder(
                new BufferedOutputStream(
                    new FileOutputStream(
                        "osoba.xml")))) {
            enc.writeObject(osoba);
            System.out.println(
                "Зрно сачувано: " + osoba);
        }

        // Обнављање из XML формата
        try (XMLDecoder dec = new XMLDecoder(
                new BufferedInputStream(
                    new FileInputStream(
                        "osoba.xml")))) {
            OsobaZrno ucitana =
                (OsobaZrno)
                    dec.readObject();
            System.out.println(
                "Зрно обновљено: " + ucitana);
        }
    }
}
