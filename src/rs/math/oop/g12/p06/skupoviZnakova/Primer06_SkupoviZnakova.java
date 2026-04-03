package rs.math.oop.g12.p06.skupoviZnakova;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Primer06_SkupoviZnakova {
    public static void main(String[] args)
        throws Exception {
        // Подразумевани скуп знакова
        System.out.println(
        "Подразумевани: "
        + Charset.defaultCharset());
 
        String tekst =
        "Ђурђевдан је леп празник.";
 
        // Записивање у UTF-8
        Path putanja = Paths.get("test.txt");
        Files.write(putanja,
        tekst.getBytes("UTF-8"));
        System.out.println(
        "UTF-8 бајтови: "
        + tekst.getBytes("UTF-8").length);
 
        // Читање из датотеке
        String ucitano = new String(
        Files.readAllBytes(putanja), "UTF-8");
        System.out.println(
        "Учитано: " + ucitano);
 
        // Конверзија између кодирања
        byte[] utf8 = tekst.getBytes("UTF-8");
        byte[] iso = tekst.getBytes("ISO-8859-1");
        System.out.println(
        "UTF-8 дужина: " + utf8.length);
        System.out.println(
        "ISO-8859-1 дужина: " + iso.length);
 
        // Доступни скупови знакова
        System.out.println(
        "Број скупова: "
        + Charset.availableCharsets().size());
    }
}
