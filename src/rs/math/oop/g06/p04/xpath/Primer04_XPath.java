package rs.math.oop.g06.p04.xpath;

import java.io.InputStream;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Primer04_XPath {
    public static void main(String[] args) throws Exception {
        // Учитавање документа
        DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
        InputStream tok = Primer04_XPath.class
            .getResourceAsStream("/biblioteka.xml");
        Document dok = fabrika.newDocumentBuilder().parse(tok);

        // Креирање XPath објекта
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Извлачење свих наслова
        String izraz1 = "//knjiga/naslov";
        NodeList naslovi = (NodeList) xpath.evaluate(
            izraz1, dok, XPathConstants.NODESET);

        System.out.println("Svi naslovi:");
        for (int i = 0; i < naslovi.getLength(); i++) {
            System.out.println("  " + naslovi.item(i).getTextContent());
        }

        // Извлачење аутора прве књиге
        String izraz2 = "/biblioteka/knjiga[@id='1']/autor";
        String autor = xpath.evaluate(izraz2, dok);
        System.out.println("Autor knjige 1: " + autor);

        // Бројање књига
        String izraz3 = "count(//knjiga)";
        double broj = (double) xpath.evaluate(
            izraz3, dok, XPathConstants.NUMBER);
        System.out.println("Broj knjiga: " + (int) broj);
    }
}
