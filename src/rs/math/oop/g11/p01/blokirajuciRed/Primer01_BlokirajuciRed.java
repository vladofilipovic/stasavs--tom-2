package rs.math.oop.g11.p01.blokirajuciRed;

import java.util.concurrent.*;

public class Primer01_BlokirajuciRed {
    public static void main(String[] args)
        throws InterruptedException {
        // Блокирајући ред капацитета 3
        BlockingQueue<Integer> red =
        new ArrayBlockingQueue<>(3);
 
        // Произвођач
        Thread proizvodjac = new Thread(() -> {
            try {
                for (int i = 1; i <= 8; i++) {
                    red.put(i);
                    System.out.println(
                    "Произведено: " + i
                    + " (у реду: "
                    + red.size() + ")");
                }
                // Сигнал за крај
                red.put(-1);
            } catch (InterruptedException e) {
                Thread.currentThread()
                .interrupt();
            }
        });
 
        // Потрошач
        Thread potrosac = new Thread(() -> {
            try {
                while (true) {
                    int v = red.take();
                    if (v == -1) break;
                    System.out.println(
                    "  Потрошено: " + v);
                    // Симулација обраде
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread()
                .interrupt();
            }
        });
 
        proizvodjac.start();
        potrosac.start();
        proizvodjac.join();
        potrosac.join();
 
        System.out.println("Завршено.");
    }
}
