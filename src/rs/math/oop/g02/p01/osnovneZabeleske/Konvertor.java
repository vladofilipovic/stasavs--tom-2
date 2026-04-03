package rs.math.oop.g02.p01.osnovneZabeleske;

// @FunctionalInterface означава интерфејс са тачно једним апстрактним методом
@FunctionalInterface
interface Konvertor<F, T> {
    T konvertuj(F ulaz);
}
