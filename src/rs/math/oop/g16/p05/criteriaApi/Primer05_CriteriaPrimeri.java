package rs.math.oop.g16.p05.criteriaApi;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.List;

public class Primer05_CriteriaPrimeri {

    public static void main(String[] args) {
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("mojaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Прост упит са условом
        CriteriaQuery<Student> cq =
            cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        cq.select(root)
        .where(cb.greaterThanOrEqualTo(
              root.get("prosek"), 9.0))
        .orderBy(cb.desc(root.get("prosek")));

        List<Student> odlikasi =
            em.createQuery(cq).getResultList();

        System.out.println("Одликаши (Criteria API):");
        odlikasi.forEach(s ->
            System.out.println("  " + s));

        // Динамички упит са више услова
        CriteriaQuery<Student> cq2 =
            cb.createQuery(Student.class);
        Root<Student> root2 = cq2.from(Student.class);

        Predicate uslov1 = cb.greaterThan(
            root2.get("prosek"), 8.0);
        Predicate uslov2 = cb.like(
            root2.get("prezime"), "%ић");
        Predicate uslov3 = cb.equal(
            root2.get("status"),
            StatusStudenta.AKTIVAN);

        cq2.select(root2).where(
            cb.and(uslov1, uslov2, uslov3));

        List<Student> filtrirani =
            em.createQuery(cq2).getResultList();

        System.out.println("\nФилтрирани:");
        filtrirani.forEach(s ->
            System.out.println("  " + s));

        em.close();
        emf.close();
    }
}
