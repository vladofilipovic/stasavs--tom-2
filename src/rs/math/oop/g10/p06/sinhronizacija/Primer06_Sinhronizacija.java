package rs.math.oop.g10.p06.sinhronizacija;

public class Primer06_Sinhronizacija {
    static int brojac = 0;
    // Објекат за закључавање
    static final Object katanac = new Object();
 
    public static void main(String[] args)
        throws InterruptedException {
        Runnable zadatak = () -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (katanac) {
                    brojac++;
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
