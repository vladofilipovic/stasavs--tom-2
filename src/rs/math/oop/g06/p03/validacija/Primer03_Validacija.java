package rs.math.oop.g06.p03.validacija;

import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class Primer03_Validacija {
    public static void main(String[] args) {
        try {
            // Учитавање XML схеме
            SchemaFactory fabrika = SchemaFactory.newInstance(
                XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream xsdTok = Primer03_Validacija.class
                .getResourceAsStream("/biblioteka.xsd");
            Schema sema = fabrika.newSchema(new StreamSource(xsdTok));

            // Креирање валидатора
            Validator validator = sema.newValidator();

            // Валидација документа
            InputStream xmlTok = Primer03_Validacija.class
                .getResourceAsStream("/biblioteka.xml");
            validator.validate(new StreamSource(xmlTok));

            System.out.println("Dokument je validan.");

        } catch (Exception e) {
            System.out.println("Dokument nije validan: " + e.getMessage());
        }
    }
}
