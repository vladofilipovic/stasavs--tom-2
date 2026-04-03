package rs.math.oop.g17.p04.filteri;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EvidencijaFilter implements Filter {
 
    @Override
    public void doFilter(ServletRequest zahtev,
        ServletResponse odgovor, FilterChain lanac)
        throws IOException, ServletException {
 
        HttpServletRequest httpZahtev =
            (HttpServletRequest) zahtev;
 
        long pocetak = System.currentTimeMillis();
 
        String metod = httpZahtev.getMethod();
        String putanja = httpZahtev.getRequestURI();
 
        // Прослеђивање захтева даље кроз ланац
        lanac.doFilter(zahtev, odgovor);
 
        long trajanje = System.currentTimeMillis() - pocetak;
        System.out.printf("[%s] %s %s – %d ms%n",
            java.time.LocalTime.now(),
            metod, putanja, trajanje);
    }
}
