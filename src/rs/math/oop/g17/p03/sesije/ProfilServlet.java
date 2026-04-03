package rs.math.oop.g17.p03.sesije;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        odgovor.setContentType("text/html; charset=UTF-8");
        PrintWriter p = odgovor.getWriter();
 
        HttpSession sesija = zahtev.getSession(false);
 
        if (sesija != null &&
            sesija.getAttribute("korisnik") != null) {
 
            String korisnik = (String)
                sesija.getAttribute("korisnik");
            String uloga = (String)
                sesija.getAttribute("uloga");
 
            p.println("Профил");
            p.printf("Корисник: %s%n", korisnik);
            p.printf("Улога: %s%n", uloga);
            p.println("Одјави се");
 
        } else {
            odgovor.sendRedirect("prijava");
        }
    }
}
