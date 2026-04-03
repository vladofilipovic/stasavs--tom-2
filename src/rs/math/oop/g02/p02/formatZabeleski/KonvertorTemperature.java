package rs.math.oop.g02.p02.formatZabeleski;

import java.lang.annotation.*;

@Testabilna
@Dokumentacija(
autor = "Марко Илић",
verzija = "2.1",
opis = "Класа за рад са температурама",
oznake = {"конверзија", "температура"}
)
class KonvertorTemperature {

    @Autor("Марко Илић")
    @Dokumentacija(autor = "Марко Илић", opis = "Целзијус у Фаренхајт")
    public static double celzijusUFarenhajt(double c) {
        return c * 9.0 / 5.0 + 32;
    }

    @Autor("Ана Сарић")
    public static double farenhajdUCelzijus(double f) {
        return (f - 32) * 5.0 / 9.0;
    }
}
