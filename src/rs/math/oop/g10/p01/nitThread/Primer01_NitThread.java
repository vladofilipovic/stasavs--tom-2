package rs.math.oop.g10.p01.nitThread;

public class Primer01_NitThread {
    // Класа која наслеђује Thread
    static class MojaNit extends Thread {
        private final String ime;
 
        MojaNit(String ime) {
            this.ime = ime;
        }
 
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(ime
                + " - корак " + i);
                try {
                    // Пауза од 100 милисекунди
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(ime
                    + " прекинута.");
                    return;
                }
            }
            System.out.println(ime
            + " завршена.");
        }
    }
 
    public static void main(String[] args) {
        MojaNit n1 = new MojaNit("Нит-А");
        MojaNit n2 = new MojaNit("Нит-Б");
 
        // Покретање нити
        n1.start();
        n2.start();
 
        System.out.println(
        "Главна нит покренула Нит-А и Нит-Б.");
    }
}
