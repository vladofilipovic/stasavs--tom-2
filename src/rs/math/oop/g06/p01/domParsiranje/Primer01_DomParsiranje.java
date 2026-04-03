package rs.math.oop.g06.p01.domParsiranje;

import java.io.InputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Primer01_DomParsiranje {
    public static void main(String[] args) throws Exception {
        // Креирање DOM парсера
        DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
        DocumentBuilder graditelj = fabrika.newDocumentBuilder();

        // Парсирање XML датотеке
        InputStream tok = Primer01_DomParsiranje.class
            .getResourceAsStream("/biblioteka.xml");
        Document dokument = graditelj.parse(tok);
        dokument.getDocumentElement().normalize();

        // Читање коренског елемента
        System.out.println("Korenski element: "
            + dokument.getDocumentElement().getNodeName());

        // Читање свих књига
        NodeList knjige = dokument.getElementsByTagName("knjiga");

        for (int i = 0; i < knjige.getLength(); i++) {
            Node cvor = knjige.item(i);

            if (cvor.getNodeType() == Node.ELEMENT_NODE) {
                Element knjiga = (Element) cvor;
                String id = knjiga.getAttribute("id");
                String naslov = knjiga
                    .getElementsByTagName("naslov")
                    .item(0).getTextContent();
                String autor = knjiga
                    .getElementsByTagName("autor")
                    .item(0).getTextContent();
                String godina = knjiga
                    .getElementsByTagName("godina")
                    .item(0).getTextContent();

                System.out.println("Knjiga " + id
                    + ": " + naslov + " - " + autor
                    + " (" + godina + ")");
            }
        }
    }
}
