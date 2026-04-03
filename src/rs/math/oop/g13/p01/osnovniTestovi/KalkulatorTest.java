package rs.math.oop.g13.p01.osnovniTestovi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class KalkulatorTest {
 
    private final Kalkulator kalkulator = new Kalkulator();
 
    @Test
    @DisplayName("Сабирање два позитивна броја")
    void testSabiranje() {
        assertEquals(5, kalkulator.saberi(2, 3));
    }
 
    @Test
    @DisplayName("Одузимање два броја")
    void testOduzimanje() {
        assertEquals(2, kalkulator.oduzmi(5, 3));
    }
 
    @Test
    @DisplayName("Множење два броја")
    void testMnozenje() {
        assertEquals(15, kalkulator.pomnozi(3, 5));
    }
 
    @Test
    @DisplayName("Дељење два броја")
    void testDeljenje() {
        assertEquals(2.5, kalkulator.podeli(5, 2), 0.001);
    }
 
    @Test
    @DisplayName("Дељење нулом баца изузетак")
    void testDeljenjeNulom() {
        assertThrows(ArithmeticException.class,
            () -> kalkulator.podeli(5, 0));
    }
 
    @Test
    @DisplayName("Сабирање са нулом")
    void testSabiranjeSaNulom() {
        assertAll("сабирање са нулом",
        () -> assertEquals(5, kalkulator.saberi(5, 0)),
        () -> assertEquals(0, kalkulator.saberi(0, 0)),
        () -> assertEquals(-3, kalkulator.saberi(-3, 0))
        );
    }
}
