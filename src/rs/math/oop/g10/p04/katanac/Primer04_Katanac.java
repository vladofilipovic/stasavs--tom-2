package rs.math.oop.g10.p04.katanac;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Primer04_Katanac {
    static int brojac = 0;
    // Катанац за заштиту бројача
    static final Lock katanac =
    new ReentrantLock();
 
    public static void main(String[] args)
        throws InterruptedException {
        Runnable zadatak = () -> {
            for (int i = 0; i < 100000; i++) {
                // Закључавање пре приступа
                katanac.lock();
                try {
                    brojac++;
                } finally {
                    // Откључавање у finally блоку
                    katanac.unlock();
                }
            }
        };
 
        Thread n1 = new Thread(zadatak);
        Thread n2 = new Thread(zadatak);
 
        n1.start();
        n2.start();
        n1.join();
        n2.join();
 
        System.out.println(
        "Очекивано: 200000");
        System.out.println(
        "Добијено:  " + brojac);
    }
}
