package rs.math.oop.g11.p03.invokeAll;

import java.util.*;
import java.util.concurrent.*;

public class Primer03_InvokeAll {
    public static void main(String[] args)
        throws Exception {
        ExecutorService servis =
        Executors.newFixedThreadPool(3);

        // Листа задатака
        List<Callable<String>> zadaci =
            new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int br = i;
            zadaci.add(() -> {
                Thread.sleep(100 * br);
                return "Задатак " + br
                + " завршен (нит: "
                + Thread.currentThread()
                    .getName() + ")";
            });
        }

        // Извршавање свих задатака
        List<Future<String>> rezultati =
        servis.invokeAll(zadaci);

        // Исписивање резултата
        for (Future<String> f : rezultati) {
            System.out.println(f.get());
        }

        servis.shutdown();
    }
}
