package rs.math.oop.g02.p06.refleksijaZabeleske;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

class Validator {
    public static List<String> validiraj(Object objekat) {
        List<String> greske = new ArrayList<>();
        Class klasa = objekat.getClass();

        for (Field polje : klasa.getDeclaredFields()) {
            polje.setAccessible(true);
            try {
                Object vrednost = polje.get(objekat);

                Obavezno obavezno = polje.getAnnotation(Obavezno.class);
                if (obavezno != null && vrednost == null) {
                    greske.add(polje.getName() + ": " + obavezno.poruka());
                    continue;
                }

                Duzina duzina = polje.getAnnotation(Duzina.class);
                if (duzina != null && vrednost instanceof String) {
                    String s = (String) vrednost;
                    if (s.length() < duzina.min() || s.length() > duzina.max()) {
                        greske.add(polje.getName() + ": " + duzina.poruka()
                            + " (тренутна дужина: " + s.length() + ")");
                    }
                }

                Opseg opseg = polje.getAnnotation(Opseg.class);
                if (opseg != null && vrednost instanceof Number) {
                    double v = ((Number) vrednost).doubleValue();
                    if (v < opseg.min() || v > opseg.max()) {
                        greske.add(polje.getName() + ": " + opseg.poruka()
                            + " (вредност: " + v + ")");
                    }
                }
            } catch (IllegalAccessException e) {
                greske.add("Грешка приступа пољу: " + polje.getName());
            }
        }
        return greske;
    }

    public static void prikazi(Object objekat) {
        Class klasa = objekat.getClass();
        List<Field> polja = new ArrayList<>();

        for (Field polje : klasa.getDeclaredFields()) {
            if (polje.isAnnotationPresent(Prikazivo.class)) {
                polja.add(polje);
            }
        }

        polja.sort((a, b) -> {
            int ra = a.getAnnotation(Prikazivo.class).redosled();
            int rb = b.getAnnotation(Prikazivo.class).redosled();
            return Integer.compare(ra, rb);
        });

        System.out.println("--- " + klasa.getSimpleName() + " ---");
        for (Field polje : polja) {
            polje.setAccessible(true);
            Prikazivo p = polje.getAnnotation(Prikazivo.class);
            String naziv = p.naziv().isEmpty() ? polje.getName() : p.naziv();
            try {
                System.out.println("  " + naziv + ": " + polje.get(objekat));
            } catch (IllegalAccessException e) {
                System.out.println("  " + naziv + ": [грешка приступа]");
            }
        }
    }
}
