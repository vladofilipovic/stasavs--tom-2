package rs.math.oop.g10.p05.uslovniObjekti;

import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class Primer05_UslovniObjekti {
    static final int KAPACITET = 5;
    static final LinkedList<Integer> bafer =
    new LinkedList<>();
    static final Lock katanac =
    new ReentrantLock();
    static final Condition nijePun =
    katanac.newCondition();
    static final Condition nijePrazan =
    katanac.newCondition();
 
    public static void main(String[] args)
        throws InterruptedException {
        // Произвођач
        Thread proizvodjac = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                katanac.lock();
                try {
                    // Чекање ако је бафер пун
                    while (bafer.size()
                        == KAPACITET) {
                        nijePun.await();
                    }
                    bafer.add(i);
                    System.out.println(
                    "Произведено: " + i
                    + " (у баферу: "
                    + bafer.size() + ")");
                    nijePrazan.signal();
                } catch (InterruptedException e) {
                    return;
                } finally {
                    katanac.unlock();
                }
            }
        });
 
        // Потрошач
        Thread potrosac = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                katanac.lock();
                try {
                    // Чекање ако је бафер празан
                    while (bafer.isEmpty()) {
                        nijePrazan.await();
                    }
                    int vrednost =
                    bafer.removeFirst();
                    System.out.println(
                    "  Потрошено: " + vrednost
                    + " (у баферу: "
                    + bafer.size() + ")");
                    nijePun.signal();
                } catch (InterruptedException e) {
                    return;
                } finally {
                    katanac.unlock();
                }
            }
        });
 
        proizvodjac.start();
        potrosac.start();
        proizvodjac.join();
        potrosac.join();
 
        System.out.println("Завршено.");
    }
}
