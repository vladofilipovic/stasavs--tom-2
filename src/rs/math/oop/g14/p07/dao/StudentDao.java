package rs.math.oop.g14.p07.dao;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    void kreirajTabelu();
    void dodaj(Student student);
    Optional<Student> nadjiPoId(int id);
    List<Student> nadjiSve();
    List<Student> nadjiPoMinProseku(double minProsek);
    void azuriraj(Student student);
    void obrisi(int id);
}
