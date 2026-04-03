package rs.math.oop.g14.p02.umetanjeICitanje;

import java.sql.*;

public class Primer02_UmetanjeICitanje {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:testbaza";

        try (Connection kon = DriverManager.getConnection(
            url, "sa", "")) {

            Statement naredba = kon.createStatement();

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

            // Уметање података
            naredba.executeUpdate(
            "INSERT INTO student (ime, prezime, indeks, prosek) " +
            "VALUES ('Марко', 'Марковић', '2021/0001', 9.15)");
            naredba.executeUpdate(
            "INSERT INTO student (ime, prezime, indeks, prosek) " +
            "VALUES ('Јелена', 'Јовановић', '2021/0002', 8.73)");
            naredba.executeUpdate(
            "INSERT INTO student (ime, prezime, indeks, prosek) " +
            "VALUES ('Никола', 'Петровић', '2021/0003', 9.52)");

            System.out.println("Уметнута 3 студента.");

            // Читање података
            ResultSet rs = naredba.executeQuery(
            "SELECT * FROM student ORDER BY prosek DESC");

            System.out.println("\nСтуденти по просеку (опадајући):");
            System.out.println("-".repeat(55));

            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String indeks = rs.getString("indeks");
                double prosek = rs.getDouble("prosek");

                System.out.printf("%d. %s %s (%s) – %.2f%n",
                    id, ime, prezime, indeks, prosek);
            }

        } catch (SQLException e) {
            System.err.println("Грешка: " + e.getMessage());
        }
    }
}
