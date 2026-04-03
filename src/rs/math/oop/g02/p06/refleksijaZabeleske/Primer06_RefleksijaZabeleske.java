package rs.math.oop.g02.p06.refleksijaZabeleske;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Primer06_RefleksijaZabeleske {
    public static void main(String[] args) {
        // Валидан студент
        Student s1 = new Student("Марко Илић", "2021/0123", 8.75, 180);
        System.out.println("Студент 1:");
        Validator.prikazi(s1);
        List<String> greske1 = Validator.validiraj(s1);
        System.out.println("Грешке: " + (greske1.isEmpty() ? "нема" : greske1));

        System.out.println();

        // Невалидан студент
        Student s2 = new Student("А", "12", 5.5, 400);
        System.out.println("Студент 2:");
        Validator.prikazi(s2);
        List<String> greske2 = Validator.validiraj(s2);
        System.out.println("Грешке:");
        for (String g : greske2) {
            System.out.println("  - " + g);
        }

        System.out.println();

        // Студент са null пољем
        Student s3 = new Student(null, "2022/0456", 7.0, 60);
        System.out.println("Студент 3:");
        List<String> greske3 = Validator.validiraj(s3);
        System.out.println("Грешке:");
        for (String g : greske3) {
            System.out.println("  - " + g);
        }
    }
}
