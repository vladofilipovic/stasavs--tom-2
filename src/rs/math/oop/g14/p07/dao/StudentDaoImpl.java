package rs.math.oop.g14.p07.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {
 
    private final Connection kon;
 
    public StudentDaoImpl(Connection kon) {
        this.kon = kon;
    }
 
    @Override
    public void kreirajTabelu() {
        try (Statement st = kon.createStatement()) {
            st.execute(
            "CREATE TABLE IF NOT EXISTS student (" +
            "  id INT PRIMARY KEY AUTO_INCREMENT," +
            "  ime VARCHAR(50) NOT NULL," +
            "  prezime VARCHAR(50) NOT NULL," +
            "  indeks VARCHAR(20) UNIQUE," +
            "  prosek DOUBLE" +
            ")"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    @Override
    public void dodaj(Student s) {
        String sql = "INSERT INTO student " +
            "(ime, prezime, indeks, prosek) " +
            "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps =
            kon.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getIme());
            ps.setString(2, s.getPrezime());
            ps.setString(3, s.getIndeks());
            ps.setDouble(4, s.getProsek());
            ps.executeUpdate();
 
            ResultSet kljucevi = ps.getGeneratedKeys();
            if (kljucevi.next()) {
                s.setId(kljucevi.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    @Override
    public Optional<Student> nadjiPoId(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement ps =
            kon.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapiraj(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    @Override
    public List<Student> nadjiSve() {
        List<Student> lista = new ArrayList<>();
        try (Statement st = kon.createStatement();
         ResultSet rs = st.executeQuery(
            "SELECT * FROM student ORDER BY prezime")) {
            while (rs.next()) {
                lista.add(mapiraj(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
 
    @Override
    public List<Student> nadjiPoMinProseku(double min) {
        List<Student> lista = new ArrayList<>();
        String sql = "SELECT * FROM student " +
            "WHERE prosek >= ? ORDER BY prosek DESC";
        try (PreparedStatement ps =
            kon.prepareStatement(sql)) {
            ps.setDouble(1, min);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(mapiraj(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
 
    @Override
    public void azuriraj(Student s) {
        String sql = "UPDATE student SET ime = ?, " +
            "prezime = ?, indeks = ?, prosek = ? " +
            "WHERE id = ?";
        try (PreparedStatement ps =
            kon.prepareStatement(sql)) {
            ps.setString(1, s.getIme());
            ps.setString(2, s.getPrezime());
            ps.setString(3, s.getIndeks());
            ps.setDouble(4, s.getProsek());
            ps.setInt(5, s.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    @Override
    public void obrisi(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement ps =
            kon.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 
    private Student mapiraj(ResultSet rs)
        throws SQLException {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setIme(rs.getString("ime"));
        s.setPrezime(rs.getString("prezime"));
        s.setIndeks(rs.getString("indeks"));
        s.setProsek(rs.getDouble("prosek"));
        return s;
    }
}
