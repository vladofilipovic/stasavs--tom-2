package rs.math.oop.g07.p05.jsonJacksonSerijalizacija;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Primer05_JsonJacksonSerijalizacija {
    public static void main(String[] args)
            throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Knjiga k = new Knjiga(
            "Мислити на Јави", "Bruce Eckel", 2006);

        // Серијализација у JSON датотеку
        mapper.writeValue(
            new File("knjiga.json"), k);

        // Серијализација у JSON стринг
        String json =
            mapper.writeValueAsString(k);
        System.out.println("JSON: " + json);

        // Десеријализација из JSON стринга
        Knjiga ucitana = mapper.readValue(
            json, Knjiga.class);
        System.out.println(
            "Објекат: " + ucitana);
    }
}
