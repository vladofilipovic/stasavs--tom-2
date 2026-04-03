package rs.math.oop.g14.p05.transakcije;

import java.sql.*;

public class Primer05_Transakcije {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:testbaza";

        try (Connection kon = DriverManager.getConnection(
            url, "sa", "")) {

            Statement st = kon.createStatement();
            st.execute(
            "CREATE TABLE racun (" +
            "  id INT PRIMARY KEY," +
            "  vlasnik VARCHAR(50)," +
            "  stanje DECIMAL(12,2)" +
            ")"
            );
            st.executeUpdate(
            "INSERT INTO racun VALUES " +
            "(1, 'Марко', 50000.00)");
            st.executeUpdate(
            "INSERT INTO racun VALUES " +
            "(2, 'Јелена', 30000.00)");

            prikaziStanja(kon);

            // Пренос средстава
            System.out.println("\nПренос 15000 дин " +
                "са рачуна Марка на рачун Јелене...");
            prenesiSredstva(kon, 1, 2, 15000);
            prikaziStanja(kon);

            // Покушај невалидног преноса
            System.out.println("\nПокушај преноса " +
                "100000 дин (недовољно средстава)...");
            prenesiSredstva(kon, 1, 2, 100000);
            prikaziStanja(kon);
        }
    }

    static void prenesiSredstva(Connection kon, int odId,
        int naId, double iznos) throws SQLException {

        kon.setAutoCommit(false);

        try {
            // Провера стања
            PreparedStatement provera = kon.prepareStatement(
            "SELECT stanje FROM racun WHERE id = ?");
            provera.setInt(1, odId);
            ResultSet rs = provera.executeQuery();
            rs.next();
            double stanje = rs.getDouble("stanje");

            if (stanje < iznos) {
                throw new SQLException(
                    "Недовољно средстава на рачуну");
            }

            // Скидање са изворног рачуна
            PreparedStatement skidanje = kon.prepareStatement(
            "UPDATE racun SET stanje = stanje - ? " +
            "WHERE id = ?");
            skidanje.setDouble(1, iznos);
            skidanje.setInt(2, odId);
            skidanje.executeUpdate();

            // Уплата на одредишни рачун
            PreparedStatement uplata = kon.prepareStatement(
            "UPDATE racun SET stanje = stanje + ? " +
            "WHERE id = ?");
            uplata.setDouble(1, iznos);
            uplata.setInt(2, naId);
            uplata.executeUpdate();

            kon.commit();
            System.out.println("Пренос успешан.");

        } catch (SQLException e) {
            kon.rollback();
            System.out.println("Пренос неуспешан: " +
                e.getMessage());
        } finally {
            kon.setAutoCommit(true);
        }
    }

    static void prikaziStanja(Connection kon)
        throws SQLException {
        ResultSet rs = kon.createStatement().executeQuery(
            "SELECT * FROM racun ORDER BY id");
        System.out.println("\nСтања рачуна:");
        while (rs.next()) {
            System.out.printf("  %s: %.2f дин%n",
                rs.getString("vlasnik"),
                rs.getDouble("stanje"));
        }
    }
}
