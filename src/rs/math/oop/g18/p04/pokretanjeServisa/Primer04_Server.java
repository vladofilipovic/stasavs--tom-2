package rs.math.oop.g18.p04.pokretanjeServisa;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Primer04_Server {

    public static final String BAZA_URI =
        "http://localhost:8080/";

    public static void main(String[] args) {
        // Конфигурација апликације
        ResourceConfig config = new ResourceConfig()
        .packages("rs.math.oop.g18")
        .register(JacksonFeature.class);

        // Покретање сервера
        HttpServer server =
        GrizzlyHttpServerFactory.createHttpServer(
            URI.create(BAZA_URI), config);

        System.out.println("Сервер покренут на " +
            BAZA_URI);
        System.out.println("Притисните Enter за " +
            "заустављање...");

        try {
            System.in.read();
        } catch (Exception e) {
            // игнориши
        }
        server.shutdownNow();
    }
}
