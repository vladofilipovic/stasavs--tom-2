package rs.math.oop.g14.p01.kreiranjeTabele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Primer01_KreiranjeTabele {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:testbaza";
        String korisnik = "sa";
        String lozinka = "";

        // Конструкција try-with-resources аутоматски
        // затвара конекцију и наредбу
        try (Connection kon = DriverManager.getConnection(
            url, korisnik, lozinka);
         Statement naredba = kon.createStatement()) {

            // Креирање табеле
            naredba.execute(
            "CREATE TABLE student (" +
            "  id INT PRIMARY KEY AUTO_INCREMENT," +
            "  ime VARCHAR(50) NOT NULL," +
            "  prezime VARCHAR(50) NOT NULL," +
            "  indeks VARCHAR(20) UNIQUE," +
            "  prosek DOUBLE" +
            ")"
            );
            System.out.println("Табела student успешно креирана.");

        } catch (SQLException e) {
            System.err.println("Грешка: " + e.getMessage());
        }
    }
}
