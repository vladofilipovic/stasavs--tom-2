package rs.math.oop.g13.p08.pretpostavke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class PretpostavkeTest {
 
    @Test
    void testSamoProdukcijaOkruzenje() {
        // Тест се извршава само ако је окружење production
        assumeTrue("production".equals(
            System.getenv("OKRUZENJE")),
            "Тест захтева production окружење");
        // Код теста...
    }
 
    @Test
    void testSaUslovnimDelom() {
        String okruzenje = System.getenv("OKRUZENJE");
        // Извршава блок само ако је услов тачан
        assumingThat("ci".equals(okruzenje), () -> {
            assertEquals(2, 1 + 1);
        });
        // Овај део се увек извршава
        assertEquals(42, 6 * 7);
    }
}
