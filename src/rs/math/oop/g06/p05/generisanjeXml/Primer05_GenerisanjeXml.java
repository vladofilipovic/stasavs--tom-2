package rs.math.oop.g06.p05.generisanjeXml;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Primer05_GenerisanjeXml {
    public static void main(String[] args) throws Exception {
        // Креирање празног документа
        DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
        Document dok = fabrika.newDocumentBuilder().newDocument();

        // Креирање коренског елемента
        Element koren = dok.createElement("studenti");
        dok.appendChild(koren);

        // Додавање студената
        String[][] podaci = {
            {"1", "Marko", "Markovic", "9.5"},
            {"2", "Ana", "Jovanovic", "9.8"},
            {"3", "Petar", "Petrovic", "8.7"}
        };

        for (String[] s : podaci) {
            Element student = dok.createElement("student");
            student.setAttribute("id", s[0]);

            Element ime = dok.createElement("ime");
            ime.setTextContent(s[1]);
            student.appendChild(ime);

            Element prezime = dok.createElement("prezime");
            prezime.setTextContent(s[2]);
            student.appendChild(prezime);

            Element prosek = dok.createElement("prosek");
            prosek.setTextContent(s[3]);
            student.appendChild(prosek);

            koren.appendChild(student);
        }

        // Записивање у датотеку
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
            "{http://xml.apache.org/xslt}" + "indent-amount", "4");

        transformer.transform(
            new DOMSource(dok),
            new StreamResult(new File("studenti.xml")));

        System.out.println("XML datoteka je kreirana.");
    }
}
