package rs.math.oop.g17.p03.sesije;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/prijava")
public class PrijavaServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        zahtev.setCharacterEncoding("UTF-8");
        String korisnik = zahtev.getParameter("korisnik");
        String lozinka = zahtev.getParameter("lozinka");
 
        odgovor.setContentType("text/html; charset=UTF-8");
        PrintWriter p = odgovor.getWriter();
 
        // УПОЗОРЕЊЕ: Лозинка је уписана директно у изворни код —
        //             није безбедно за продукцију
        if ("admin".equals(korisnik) &&
            "tajna123".equals(lozinka)) {
 
            // Креирање сесије
            HttpSession sesija = zahtev.getSession(true);
            sesija.setAttribute("korisnik", korisnik);
            sesija.setAttribute("uloga", "administrator");
            sesija.setMaxInactiveInterval(30 * 60);
 
            p.println("Добродошли, " +
                korisnik + "!");
            p.println("Сесија ID: " +
                sesija.getId() + "");
            p.println("Профил");
 
        } else {
            p.println("Неисправни подаци");
        }
    }
}
