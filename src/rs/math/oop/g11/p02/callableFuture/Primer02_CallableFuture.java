package rs.math.oop.g11.p02.callableFuture;

import java.util.*;
import java.util.concurrent.*;

public class Primer02_CallableFuture {
    // Задатак који рачуна суму опсега
    static Callable<Long> sumaOpsega(
        int od, int doo) {
        return () -> {
            long suma = 0;
            for (int i = od; i <= doo; i++) {
                suma += i;
            }
            System.out.println(
            Thread.currentThread().getName()
            + ": сума(" + od + ".." + doo
            + ") = " + suma);
            return suma;
        };
    }
 
    public static void main(String[] args)
        throws Exception {
        // Креирање скупа од 3 нити
        ExecutorService servis =
        Executors.newFixedThreadPool(3);
 
        // Предавање задатака
        Future<Long> f1 = servis.submit(
        sumaOpsega(1, 250000));
        Future<Long> f2 = servis.submit(
        sumaOpsega(250001, 500000));
        Future<Long> f3 = servis.submit(
        sumaOpsega(500001, 750000));
        Future<Long> f4 = servis.submit(
        sumaOpsega(750001, 1000000));
 
        // Преузимање резултата
        long ukupno = f1.get() + f2.get()
        + f3.get() + f4.get();
 
        System.out.println(
        "Укупна сума: " + ukupno);
 
        // Гашење сервиса
        servis.shutdown();
    }
}
