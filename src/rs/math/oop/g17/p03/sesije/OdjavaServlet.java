package rs.math.oop.g17.p03.sesije;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/odjava")
public class OdjavaServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        HttpSession sesija = zahtev.getSession(false);
        if (sesija != null) {
            sesija.invalidate(); // Уништавање сесије
        }
        odgovor.sendRedirect("prijava");
    }
}
