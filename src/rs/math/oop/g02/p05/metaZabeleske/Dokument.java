package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Serijalizabilna(format = "XML")
@VerzijaIzvrsavanja("1.0")
class Dokument {
    private String sadrzaj;

    public Dokument(String sadrzaj) { this.sadrzaj = sadrzaj; }

    @SamoZaMetode("враћа садржај")
    public String getSadrzaj() { return sadrzaj; }

    @Napomena("Овај метод треба оптимизовати")
    public void obradi() {
        System.out.println("Обрада документа: " + sadrzaj);
    }

    @Raspored(dan = "понедељак", sat = 9)
    @Raspored(dan = "среда", sat = 14)
    @Raspored(dan = "петак", sat = 9)
    public void arhiviraj() {
        System.out.println("Архивирање документа");
    }
}
