package rs.math.oop.g01.p07.pozivMetoda;

import java.lang.reflect.Method;

class Kalkulator {
    public int saberi(int a, int b) { return a + b; }
    public double podeli(double a, double b) {
        if (b == 0) throw new ArithmeticException("Дељење нулом!");
        return a / b;
    }
    private String tajnaPoruka() {
        return "Ово је приватни метод!";
    }
    public static int kvadrat(int n) { return n * n; }
}
