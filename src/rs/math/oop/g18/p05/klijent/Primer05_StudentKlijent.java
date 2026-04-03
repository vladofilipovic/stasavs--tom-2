package rs.math.oop.g18.p05.klijent;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;
import java.util.List;

public class Primer05_StudentKlijent {

    private static final String BAZA =
        "http://localhost:8080/api/studenti";

    public static void main(String[] args) {
        Client klijent = ClientBuilder.newClient();

        // GET – читање свих
        Response odgovor = klijent.target(BAZA)
        .request(MediaType.APPLICATION_JSON)
        .get();

        System.out.println("Статус: " +
            odgovor.getStatus());
        List<Student> studenti = odgovor.readEntity(
        new GenericType<List<Student>>() {});
        studenti.forEach(s ->
        System.out.println("  " + s));

        // POST – креирање
        Student novi = new Student(null, "Ана",
            "Анић", "2021/0004", 8.95);

        Response kreiranOdgovor = klijent.target(BAZA)
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.json(novi));

        System.out.println("\nКреиран (" +
            kreiranOdgovor.getStatus() + "): " +
            kreiranOdgovor.readEntity(Student.class));

        // PUT – ажурирање
        novi.setProsek(9.10);
        Response azuriranOdgovor = klijent
        .target(BAZA + "/3")
        .request(MediaType.APPLICATION_JSON)
        .put(Entity.json(novi));

        System.out.println("Ажуриран (" +
            azuriranOdgovor.getStatus() + ")");

        // DELETE – брисање
        Response obrisanOdgovor = klijent
        .target(BAZA + "/3")
        .request()
        .delete();

        System.out.println("Обрисан (" +
            obrisanOdgovor.getStatus() + ")");

        klijent.close();
    }
}
