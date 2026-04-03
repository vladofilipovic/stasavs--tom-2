package rs.math.oop.g10.p03.uslovTrke;

public class Primer03_UslovTrke {
    // Дељени ресурс
    static int brojac = 0;
 
    public static void main(String[] args)
        throws InterruptedException {
        Runnable zadatak = () -> {
            for (int i = 0; i < 100000; i++) {
                // Ова операција НИЈЕ атомична
                brojac++;
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
