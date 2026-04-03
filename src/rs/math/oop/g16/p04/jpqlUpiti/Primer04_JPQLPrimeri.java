package rs.math.oop.g16.p04.jpqlUpiti;

import jakarta.persistence.*;
import java.util.List;

public class Primer04_JPQLPrimeri {

    public static void main(String[] args) {
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("mojaPU");
        EntityManager em = emf.createEntityManager();

        // Прост упит са условом
        List<Student> odlikasi = em.createQuery(
        "SELECT s FROM StudentP04 s " +
        "WHERE s.prosek >= :minProsek " +
        "ORDER BY s.prosek DESC", Student.class)
        .setParameter("minProsek", 9.0)
        .getResultList();

        System.out.println("Одликаши:");
        odlikasi.forEach(s ->
            System.out.println("  " + s));

        // Агрегатни упити
        Double prosecniProsek = em.createQuery(
        "SELECT AVG(s.prosek) FROM StudentP04 s",
        Double.class).getSingleResult();
        System.out.println("\nПросечан просек: " +
            String.format("%.2f", prosecniProsek));

        // Упит са спајањем
        List<Object[]> rezultati = em.createQuery(
        "SELECT d.naziv, COUNT(p), AVG(p.espb) " +
        "FROM DepartmanP04 d JOIN d.predmeti p " +
        "GROUP BY d.naziv", Object[].class)
        .getResultList();

        System.out.println("\nСтатистика по департманима:");
        for (Object[] red : rezultati) {
            System.out.printf("  %s: %d предмета, " +
                "просечно %.1f ЕСПБ%n",
                red[0], red[1], red[2]);
        }

        // Именовани упит (Named Query)
        // Дефинише се на класи ентитета:
        // @NamedQuery(name = "Student.poStatusu",
        // query = "SELECT s FROM Student s
        //          WHERE s.status = :status")

        // Ажурирање помоћу упита
        em.getTransaction().begin();
        int azurirano = em.createQuery(
        "UPDATE StudentP04 s SET s.status = :noviStatus " +
        "WHERE s.prosek < :granica")
        .setParameter("noviStatus",
                StatusStudenta.ISPISAN)
        .setParameter("granica", 6.0)
        .executeUpdate();
        em.getTransaction().commit();

        System.out.println("\nАжурирано " +
            azurirano + " студената");

        em.close();
        emf.close();
    }
}
