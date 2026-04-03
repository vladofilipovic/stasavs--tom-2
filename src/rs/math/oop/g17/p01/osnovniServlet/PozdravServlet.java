package rs.math.oop.g17.p01.osnovniServlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/pozdrav")
public class PozdravServlet extends HttpServlet {
 
    private int brojPoseta;
 
    @Override
    public void init() {
        brojPoseta = 0;
        System.out.println("Сервлет иницијализован.");
    }
 
    @Override
    protected void doGet(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        brojPoseta++;
 
        odgovor.setContentType("text/html; charset=UTF-8");
        PrintWriter pisac = odgovor.getWriter();
 
        String ime = zahtev.getParameter("ime");
        if (ime == null || ime.isEmpty()) {
            ime = "непознати посетиоче";
        }
 
        String vreme = LocalDateTime.now().format(
        DateTimeFormatter.ofPattern("HH:mm:ss"));
 
        pisac.println("");
        pisac.println("");
        pisac.println("Поздрав");
        pisac.println("");
        pisac.printf("Здраво, %s!%n", ime);
        pisac.printf("Тренутно време: %s%n", vreme);
        pisac.printf("Број посета: %d%n", brojPoseta);
        pisac.println("");
    }
 
    @Override
    public void destroy() {
        System.out.println("Сервлет уништен. " +
            "Укупно посета: " + brojPoseta);
    }
}
