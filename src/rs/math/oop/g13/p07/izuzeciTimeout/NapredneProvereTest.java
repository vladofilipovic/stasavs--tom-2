package rs.math.oop.g13.p07.izuzeciTimeout;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class NapredneProvereTest {
 
    @Test
    void testIzuzetakSaPorukom() {
        ArithmeticException izuzetak = assertThrows(
        ArithmeticException.class,
        () -> {
            int rezultat = 10 / 0;
        }
        );
        // Провера поруке изузетка
        assertEquals("/ by zero", izuzetak.getMessage());
    }
 
    @Test
    void testVremenskoOgranicenje() {
        // Тест мора завршити за 2 секунде
        assertTimeout(Duration.ofSeconds(2), () -> {
            // Симулација операције
            Thread.sleep(500);
        });
    }
 
    @Test
    void testVremenskoOgranicenjeSaRezultatom() {
        // assertTimeout враћа резултат извршавања
        String rezultat = assertTimeout(Duration.ofSeconds(2),
            () -> {
            Thread.sleep(100);
            return "Успешно";
        });
        assertEquals("Успешно", rezultat);
    }
 
    @Test
    void testVisestrukiIzuzeci() {
        // Провера да различити улази бацају исти тип изузетка
        assertAll("Дељење нулом",
        () -> assertThrows(ArithmeticException.class,
                () -> { int r = 1 / 0; }),
        () -> assertThrows(ArithmeticException.class,
                () -> { int r = -5 / 0; }),
        () -> assertThrows(ArithmeticException.class,
                () -> { int r = Integer.MAX_VALUE / 0; })
        );
    }
}
