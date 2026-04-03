package rs.math.oop.g06.p02.saxParsiranje;

import java.io.InputStream;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class Primer02_SaxParsiranje {
    public static void main(String[] args) throws Exception {
        SAXParserFactory fabrika = SAXParserFactory.newInstance();
        SAXParser parser = fabrika.newSAXParser();

        // Дефинисање ослушкивача догађаја
        DefaultHandler osluskivac = new DefaultHandler() {
            String trenutniElement = "";
            String naslov = "";
            String autor = "";

            @Override
            public void startElement(String uri, String imeL, String ime,
                    Attributes atributi) throws SAXException {
                trenutniElement = ime;
                if ("knjiga".equals(ime)) {
                    System.out.print("Knjiga " + atributi.getValue("id") + ": ");
                }
            }

            @Override
            public void characters(char[] znakovi, int pocetak, int duzina)
                    throws SAXException {
                String tekst = new String(znakovi, pocetak, duzina).trim();
                if ("naslov".equals(trenutniElement)) {
                    naslov = tekst;
                } else if ("autor".equals(trenutniElement)) {
                    autor = tekst;
                }
            }

            @Override
            public void endElement(String uri, String imeL, String ime)
                    throws SAXException {
                if ("knjiga".equals(ime)) {
                    System.out.println(naslov + " - " + autor);
                    naslov = "";
                    autor = "";
                }
                trenutniElement = "";
            }
        };

        InputStream tok = Primer02_SaxParsiranje.class
            .getResourceAsStream("/biblioteka.xml");
        parser.parse(tok, osluskivac);
    }
}
