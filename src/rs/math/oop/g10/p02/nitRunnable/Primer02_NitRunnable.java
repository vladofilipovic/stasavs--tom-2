package rs.math.oop.g10.p02.nitRunnable;

public class Primer02_NitRunnable {
    public static void main(String[] args)
        throws InterruptedException {
        // Креирање нити помоћу Runnable
        Runnable zadatak = () -> {
            String ime =
            Thread.currentThread().getName();
            for (int i = 1; i <= 3; i++) {
                System.out.println(ime
                + " - корак " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
 
        Thread n1 = new Thread(zadatak, "Нит-1");
        Thread n2 = new Thread(zadatak, "Нит-2");
 
        n1.start();
        n2.start();
 
        // Чекање да обе нити заврше
        n1.join();
        n2.join();
 
        System.out.println(
        "Обе нити завршене.");
    }
}
