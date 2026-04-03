package rs.math.oop.g14.p06.metapodaci;

import java.sql.*;

public class Primer06_Metapodaci {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:testbaza";

        try (Connection kon = DriverManager.getConnection(
            url, "sa", "")) {

            kon.createStatement().execute(
            "CREATE TABLE zaposleni (" +
            "  id INT PRIMARY KEY AUTO_INCREMENT," +
            "  ime VARCHAR(50) NOT NULL," +
            "  plata DECIMAL(10,2)," +
            "  datum_zaposlenja DATE" +
            ")"
            );

            // Метаподаци базе
            DatabaseMetaData dbMeta = kon.getMetaData();
            System.out.println("База: " +
                dbMeta.getDatabaseProductName() +
                " " + dbMeta.getDatabaseProductVersion());
            System.out.println("JDBC управљачки програм: " +
                dbMeta.getDriverName());

            // Информације о колонама
            ResultSet kolone = dbMeta.getColumns(
                null, null, "ZAPOSLENI", null);

            System.out.println("\nКолоне табеле ZAPOSLENI:");
            while (kolone.next()) {
                System.out.printf("  %s – %s (%s)%n",
                    kolone.getString("COLUMN_NAME"),
                    kolone.getString("TYPE_NAME"),
                    kolone.getInt("NULLABLE") == 0 ?
                            "NOT NULL" : "NULL");
            }

            // Метаподаци резултата
            ResultSet rs = kon.createStatement().executeQuery(
                "SELECT * FROM zaposleni");
            ResultSetMetaData rsMeta = rs.getMetaData();

            System.out.println("\nМетаподаци резултата:");
            for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
                System.out.printf("  Колона %d: %s (%s)%n",
                    i,
                    rsMeta.getColumnName(i),
                    rsMeta.getColumnTypeName(i));
            }
        }
    }
}
