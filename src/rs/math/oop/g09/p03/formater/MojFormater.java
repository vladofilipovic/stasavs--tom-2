package rs.math.oop.g09.p03.formater;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

class MojFormater extends Formatter {
    private static final DateTimeFormatter df =
        DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord zapis) {
        return String.format("[%s] [%s] %s: %s%n",
            LocalDateTime.now().format(df),
            zapis.getLevel(),
            zapis.getLoggerName(),
            zapis.getMessage());
    }
}
