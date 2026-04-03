package rs.math.oop.g16.p02.crudOperacije;

import jakarta.persistence.*;
import java.util.List;

public class Primer02_StudentOperacije {

    public static void main(String[] args) {
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("mojaPU");
        EntityManager em = emf.createEntityManager();

        // Чување ентитета
        em.getTransaction().begin();

        Student s1 = new Student("Марко", "Марковић",
            "2021/0001", 9.15);
        Student s2 = new Student("Јелена", "Јовановић",
            "2021/0002", 8.73);
        Student s3 = new Student("Никола", "Петровић",
            "2021/0003", 9.52);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        em.getTransaction().commit();
        System.out.println("Сачувана 3 студента.");

        // Читање по примарном кључу
        Student pronadjen = em.find(Student.class, 1L);
        System.out.println("\nПронађен: " + pronadjen);

        // Ажурирање
        em.getTransaction().begin();
        pronadjen.setProsek(9.35);
        em.getTransaction().commit();
        System.out.println("Ажуриран: " + pronadjen);

        // Читање свих ентитета
        List<Student> svi = em.createQuery(
            "SELECT s FROM StudentP02 s ORDER BY s.prosek DESC",
            Student.class).getResultList();

        System.out.println("\nСви студенти:");
        svi.forEach(s -> System.out.println("  " + s));

        // Брисање
        em.getTransaction().begin();
        em.remove(em.find(Student.class, 2L));
        em.getTransaction().commit();

        long broj = em.createQuery(
        "SELECT COUNT(s) FROM StudentP02 s", Long.class)
        .getSingleResult();
        System.out.println("\nПосле брисања: " +
            broj + " студената");

        em.close();
        emf.close();
    }
}
