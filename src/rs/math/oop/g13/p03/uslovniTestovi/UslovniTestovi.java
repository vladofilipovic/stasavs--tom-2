package rs.math.oop.g13.p03.uslovniTestovi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class UslovniTestovi {
 
    @Test
    @EnabledOnOs(OS.LINUX)
    void samoNaLinuksu() {
        System.out.println("Овај тест се извршава само на Линуксу");
    }
 
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void samoNaVindouzu() {
        System.out.println("Овај тест се извршава само на Виндоузу");
    }
 
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void samoNaJava17() {
        System.out.println("Овај тест захтева Јаву 17");
    }
 
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void samoNa64Bita() {
        System.out.println("Овај тест се извршава само на " +
            "64-битном систему");
    }
 
    @Test
    @EnabledIfEnvironmentVariable(named = "CI", matches = "true")
    void samoNaCIServeru() {
        System.out.println("Овај тест се извршава само у " +
            "CI окружењу");
    }
 
    @Test
    @Disabled("Привремено онемогућен до исправке бага #123")
    void privrememoOnemogucen() {
        // Овај тест се прескаче
    }
}
