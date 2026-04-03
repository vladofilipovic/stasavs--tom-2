package rs.math.oop.g11.p05.konkurentneKolekcije;

import java.util.*;
import java.util.concurrent.*;

public class Primer05_KonkurentneKolekcije {
    public static void main(String[] args)
        throws InterruptedException {
        ConcurrentHashMap<String, Integer> mapa =
        new ConcurrentHashMap<>();
 
        // Нити конкурентно уписују вредности
        Runnable zadatak = () -> {
            String ime =
            Thread.currentThread().getName();
            for (int i = 1; i <= 1000; i++) {
                mapa.merge(ime, 1, Integer::sum);
            }
        };
 
        Thread n1 = new Thread(zadatak, "Нит-А");
        Thread n2 = new Thread(zadatak, "Нит-Б");
        Thread n3 = new Thread(zadatak, "Нит-В");
 
        n1.start(); n2.start(); n3.start();
        n1.join(); n2.join(); n3.join();
 
        System.out.println(
        "Садржај мапе:");
        mapa.forEach((kljuc, vrednost) ->
        System.out.println(
            "  " + kljuc + ": " + vrednost));
 
        System.out.println(
        "Укупно записа: "
        + mapa.values().stream()
            .mapToInt(Integer::intValue)
            .sum());
    }
}
