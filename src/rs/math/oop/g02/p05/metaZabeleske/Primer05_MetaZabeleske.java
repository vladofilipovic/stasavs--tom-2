package rs.math.oop.g02.p05.metaZabeleske;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Primer05_MetaZabeleske {
    public static void main(String[] args) throws Exception {
        // 1. @Inherited демонстрација
        System.out.println("=== @Inherited ===");
        Serijalizabilna s1 = Dokument.class.getAnnotation(Serijalizabilna.class);
        Serijalizabilna s2 = PoverljivDokument.class.getAnnotation(Serijalizabilna.class);
        System.out.println("Dokument има @Serijalizabilna: " + (s1 != null));
        System.out.println("PoverljivDokument наслеђује @Serijalizabilna: " + (s2 != null));
        if (s2 != null) {
            System.out.println("  Формат: " + s2.format());
        }

        // 2. @Retention демонстрација
        System.out.println("\n=== @Retention ===");
        VerzijaIzvrsavanja vi = Dokument.class.getAnnotation(VerzijaIzvrsavanja.class);
        System.out.println("@VerzijaIzvrsavanja (RUNTIME): "
            + (vi != null ? vi.value() : "недоступна"));

        Method obrada = Dokument.class.getMethod("obradi");
        Napomena nap = obrada.getAnnotation(Napomena.class);
        System.out.println("@Napomena (SOURCE): "
            + (nap != null ? nap.value() : "недоступна у време извршавања"));

        // 3. @Repeatable демонстрација (Јава 8)
        System.out.println("\n=== @Repeatable ===");
        Method arhiviranje = Dokument.class.getMethod("arhiviraj");
        Raspored[] rasporedi = arhiviranje.getAnnotationsByType(Raspored.class);
        System.out.println("Распоред архивирања:");
        for (Raspored r : rasporedi) {
            System.out.println("  " + r.dan() + " у " + r.sat() + ":00");
        }

        // 4. @Target демонстрација
        System.out.println("\n=== @Target ===");
        Method getSadrzaj = Dokument.class.getMethod("getSadrzaj");
        SamoZaMetode szm = getSadrzaj.getAnnotation(SamoZaMetode.class);
        if (szm != null) {
            System.out.println("@SamoZaMetode на getSadrzaj(): " + szm.value());
        }
    }
}
