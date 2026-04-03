package rs.math.oop.g14.p03.pripremljeneNaredbe;

import java.sql.*;

public class Primer03_PripremljeneNaredbe {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:testbaza";

        try (Connection kon = DriverManager.getConnection(
            url, "sa", "")) {

            // Креирање табеле
            kon.createStatement().execute(
            "CREATE TABLE proizvod (" +
            "  id INT PRIMARY KEY AUTO_INCREMENT," +
            "  naziv VARCHAR(100) NOT NULL," +
            "  cena DECIMAL(10,2)," +
            "  kolicina INT DEFAULT 0" +
            ")"
            );

            // Припремљена наредба за уметање
            String sqlUmetanje = "INSERT INTO proizvod " +
                "(naziv, cena, kolicina) VALUES (?, ?, ?)";

            try (PreparedStatement ps =
                kon.prepareStatement(sqlUmetanje)) {

                // Уметање више производа
                String[][] proizvodi = {
                    {"Лаптоп", "89999.99", "15"},
                    {"Миш", "2499.00", "120"},
                    {"Тастатура", "4999.50", "85"},
                    {"Монитор", "45999.00", "30"},
                    {"Слушалице", "7999.99", "60"}
                };

                for (String[] p : proizvodi) {
                    ps.setString(1, p[0]);
                    ps.setBigDecimal(2,
                        new java.math.BigDecimal(p[1]));
                    ps.setInt(3, Integer.parseInt(p[2]));
                    ps.executeUpdate();
                }
                System.out.println("Уметнуто " +
                    proizvodi.length + " производа.");
            }

            // Припремљена наредба за претрагу
            String sqlPretraga = "SELECT * FROM proizvod " +
                "WHERE cena BETWEEN ? AND ? ORDER BY cena";

            try (PreparedStatement ps =
                kon.prepareStatement(sqlPretraga)) {

                ps.setBigDecimal(1,
                    new java.math.BigDecimal("2000"));
                ps.setBigDecimal(2,
                    new java.math.BigDecimal("10000"));

                ResultSet rs = ps.executeQuery();
                System.out.println("\nПроизводи од 2000 до 10000 дин:");
                while (rs.next()) {
                    System.out.printf("  %s – %.2f дин " +
                        "(на стању: %d)%n",
                        rs.getString("naziv"),
                        rs.getDouble("cena"),
                        rs.getInt("kolicina"));
                }
            }

            // Припремљена наредба за ажурирање
            String sqlAzuriranje = "UPDATE proizvod " +
                "SET cena = cena * ? WHERE naziv = ?";

            try (PreparedStatement ps =
                kon.prepareStatement(sqlAzuriranje)) {
                ps.setDouble(1, 0.9); // 10% попуст
                ps.setString(2, "Лаптоп");
                int izmenjeno = ps.executeUpdate();
                System.out.println("\nАжурирано " +
                    izmenjeno + " редова.");
            }

        }
    }
}
