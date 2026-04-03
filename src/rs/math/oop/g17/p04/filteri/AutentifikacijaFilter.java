package rs.math.oop.g17.p04.filteri;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/zasticeno/*")
public class AutentifikacijaFilter implements Filter {
 
    @Override
    public void doFilter(ServletRequest zahtev,
        ServletResponse odgovor, FilterChain lanac)
        throws IOException, ServletException {
 
        HttpServletRequest httpZahtev =
            (HttpServletRequest) zahtev;
        HttpServletResponse httpOdgovor =
            (HttpServletResponse) odgovor;
 
        HttpSession sesija = httpZahtev.getSession(false);
 
        if (sesija != null &&
            sesija.getAttribute("korisnik") != null) {
            // Корисник је пријављен
            lanac.doFilter(zahtev, odgovor);
        } else {
            // Преусмеравање на пријаву
            httpOdgovor.sendRedirect(
            httpZahtev.getContextPath() + "/prijava");
        }
    }
}
