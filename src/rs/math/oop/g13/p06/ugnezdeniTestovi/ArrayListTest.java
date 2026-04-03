package rs.math.oop.g13.p06.ugnezdeniTestovi;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестови за ArrayList")
class ArrayListTest {

    private List<String> lista;
 
    @BeforeEach
    void priprema() {
        lista = new ArrayList<>();
    }
 
    @Nested
    @DisplayName("Када је листа празна")
    class KadaJePrazna {
 
        @Test
        @DisplayName("величина је нула")
        void velicinaJeNula() {
            assertEquals(0, lista.size());
        }
 
        @Test
        @DisplayName("isEmpty враћа true")
        void jePrazna() {
            assertTrue(lista.isEmpty());
        }
 
        @Test
        @DisplayName("get баца IndexOutOfBoundsException")
        void getBacaIzuzetak() {
            assertThrows(IndexOutOfBoundsException.class,
                () -> lista.get(0));
        }
    }
 
    @Nested
    @DisplayName("Након додавања елемента")
    class NakonDodavanja {
 
        @BeforeEach
        void dodajElement() {
            lista.add("елемент");
        }
 
        @Test
        @DisplayName("величина је један")
        void velicinaJeJedan() {
            assertEquals(1, lista.size());
        }
 
        @Test
        @DisplayName("isEmpty враћа false")
        void nijeVisePrazna() {
            assertFalse(lista.isEmpty());
        }
 
        @Test
        @DisplayName("садржи додати елемент")
        void sadrziElement() {
            assertTrue(lista.contains("елемент"));
        }
 
        @Nested
        @DisplayName("Након уклањања елемента")
        class NakonUklanjanja {
 
            @BeforeEach
            void ukloniElement() {
                lista.remove(0);
            }
 
            @Test
            @DisplayName("листа је поново празна")
            void ponovoPrazna() {
                assertTrue(lista.isEmpty());
            }
        }
    }
}
