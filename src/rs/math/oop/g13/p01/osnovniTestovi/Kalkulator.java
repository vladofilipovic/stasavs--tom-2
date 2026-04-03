package rs.math.oop.g13.p01.osnovniTestovi;

public class Kalkulator {
 
    public int saberi(int a, int b) {
        return a + b;
    }
 
    public int oduzmi(int a, int b) {
        return a - b;
    }
 
    public int pomnozi(int a, int b) {
        return a * b;
    }
 
    public double podeli(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(
                "Дељење нулом није дозвољено");
        }
        return (double) a / b;
    }
}
