package rs.math.oop.g14.p07.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SkupKonekcija {
 
    private static HikariDataSource dataSource;
 
    static {
        HikariConfig config = new HikariConfig();
        // H2 in-memory — подесити за тестирање без MySQL сервера
        // За MySQL: config.setJdbcUrl("jdbc:mysql://localhost:3306/mojabaza");
        // За MySQL: config.setUsername("korisnik");
        // За MySQL: config.setPassword("lozinka");
        config.setJdbcUrl("jdbc:h2:mem:testbaza;DB_CLOSE_DELAY=-1");
        config.setUsername("sa");
        // УПОЗОРЕЊЕ: Празна лозинка је прихватљива само за тестирање —
        //             није безбедно за продукцију
        config.setPassword("");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);

        dataSource = new HikariDataSource(config);
    }
 
    public static Connection getConnection()
        throws SQLException {
        return dataSource.getConnection();
    }
 
    public static void zatvori() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
