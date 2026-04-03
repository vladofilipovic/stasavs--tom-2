package rs.math.oop.g14.p04.serijskoUmetanje;

import java.sql.*;

public class Primer04_SerijskoUmetanje {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:testbaza";

        try (Connection kon = DriverManager.getConnection(
            url, "sa", "")) {

            kon.createStatement().execute(
            "CREATE TABLE merenje (" +
            "  id INT PRIMARY KEY AUTO_INCREMENT," +
            "  vrednost DOUBLE," +
            "  vreme TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ")"
            );

            // Искључивање аутоматског потврђивања
            kon.setAutoCommit(false);

            String sql = "INSERT INTO merenje (vrednost) " +
                "VALUES (?)";

            try (PreparedStatement ps =
                kon.prepareStatement(sql)) {

                long pocetak = System.currentTimeMillis();

                for (int i = 0; i < 10000; i++) {
                    ps.setDouble(1, Math.random() * 100);
                    ps.addBatch();

                    // Извршавање на сваких 1000 редова
                    if ((i + 1) % 1000 == 0) {
                        ps.executeBatch();
                    }
                }
                ps.executeBatch(); // преостали редови

                // Потврђивање трансакције
                kon.commit();

                long kraj = System.currentTimeMillis();
                System.out.println("Уметнуто 10000 редова за " +
                    (kraj - pocetak) + " ms");
            }

            // Провера
            ResultSet rs = kon.createStatement().executeQuery(
                "SELECT COUNT(*), AVG(vrednost), " +
                "MIN(vrednost), MAX(vrednost) FROM merenje");
            if (rs.next()) {
                System.out.printf("Број редова: %d%n",
                    rs.getInt(1));
                System.out.printf("Просек: %.2f%n",
                    rs.getDouble(2));
                System.out.printf("Минимум: %.2f%n",
                    rs.getDouble(3));
                System.out.printf("Максимум: %.2f%n",
                    rs.getDouble(4));
            }
        }
    }
}
