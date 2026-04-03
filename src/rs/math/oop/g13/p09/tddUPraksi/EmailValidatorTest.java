package rs.math.oop.g13.p09.tddUPraksi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестови за EmailValidator")
class EmailValidatorTest {
 
    private final EmailValidator validator =
        new EmailValidator();
 
    @ParameterizedTest
    @ValueSource(strings = {
        "korisnik@domen.com",
        "ime.prezime@firma.rs",
        "test123@test.org"
    })
    @DisplayName("Исправне адресе треба да прођу валидацију")
    void ispravneAdrese(String email) {
        assertTrue(validator.jeValidan(email),
            email + " треба да буде валидан");
    }
 
    @ParameterizedTest
    @ValueSource(strings = {
        "bez-at-znaka",
        "@nema-korisnika.com",
        "korisnik@",
        "korisnik@.com",
        "",
        "korisnik@domen",
        "kor is nik@domen.com"
    })
    @DisplayName("Неисправне адресе не треба да прођу валидацију")
    void neispravneAdrese(String email) {
        assertFalse(validator.jeValidan(email),
            email + " не треба да буде валидан");
    }
 
    @Test
    @DisplayName("null адреса не треба да прође валидацију")
    void nullAdresa() {
        assertFalse(validator.jeValidan(null));
    }
}
