package rs.math.oop.g13.p04.parametrizovaniTestovi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

class ParametrizovaniTestovi {
 
    // Тест са вредностима из забелешке
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 8, 13})
    void testPozitivniBrojevi(int broj) {
        assertTrue(broj > 0,
            "Број " + broj + " треба да буде позитиван");
    }
 
    // Тест са null и празним вредностима
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testPrazniStringovi(String tekst) {
        assertTrue(tekst == null || tekst.trim().isEmpty());
    }
 
    // Тест са CSV вредностима
    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 3, 8",
        "10, -5, 5",
        "0, 0, 0"
    })
    void testSabiranje(int a, int b, int ocekivano) {
        Kalkulator kalkulator = new Kalkulator();
        assertEquals(ocekivano, kalkulator.saberi(a, b));
    }
 
    // Тест са enum вредностима
    @ParameterizedTest
    @EnumSource(java.time.Month.class)
    void testMeseci(java.time.Month mesec) {
        int vrednost = mesec.getValue();
        assertTrue(vrednost >= 1 && vrednost <= 12);
    }
 
    // Тест са методом као извором параметара
    @ParameterizedTest
    @MethodSource("generisiPodatke")
    void testSaMetodom(String ulaz, int ocekivanaDuzina) {
        assertEquals(ocekivanaDuzina, ulaz.length());
    }
 
    static java.util.stream.Stream generisiPodatke() {
        return java.util.stream.Stream.of(
        Arguments.of("Здраво", 6),
        Arguments.of("JUnit", 5),
        Arguments.of("", 0)
        );
    }
}
