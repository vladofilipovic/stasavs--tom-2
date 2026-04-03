package rs.math.oop.g13.p02.zivotniCiklus;

import org.junit.jupiter.api.*;

class ZivotniCiklusTest {
 
    @BeforeAll
    static void inicijalizacijaKlase() {
        System.out.println("@BeforeAll – пре свих тестова");
    }
 
    @AfterAll
    static void zavrsetakKlase() {
        System.out.println("@AfterAll – после свих тестова");
    }
 
    @BeforeEach
    void priprema() {
        System.out.println("  @BeforeEach – пре теста");
    }
 
    @AfterEach
    void ciscenje() {
        System.out.println("  @AfterEach – после теста");
    }
 
    @Test
    void prviTest() {
        System.out.println("Извршава се prviTest()");
    }
 
    @Test
    void drugiTest() {
        System.out.println("Извршава се drugiTest()");
    }
}
