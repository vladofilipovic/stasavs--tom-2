package rs.math.oop.g17.p02.obradaFormi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registracija")
public class RegistracijaServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        odgovor.setContentType("text/html; charset=UTF-8");
        PrintWriter p = odgovor.getWriter();
 
        p.println("");
        p.println("");
        p.println("Регистрација");
        p.println("");
        p.println("  Име: ");
        p.println("  Презиме: ");
        p.println("  Email: <input name='email' " +
            "type='email'/>");
        p.println("  " +
            "Региструј се");
        p.println("");
        p.println("");
    }
 
    @Override
    protected void doPost(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        zahtev.setCharacterEncoding("UTF-8");
        odgovor.setContentType("text/html; charset=UTF-8");
 
        String ime = zahtev.getParameter("ime");
        String prezime = zahtev.getParameter("prezime");
        String email = zahtev.getParameter("email");
 
        PrintWriter p = odgovor.getWriter();
        p.println("");
        p.println("");
 
        if (ime != null && !ime.isEmpty() &&
            email != null && !email.isEmpty()) {
            p.println("Регистрација успешна");
            // УПОЗОРЕЊЕ: Параметри се исписују без заштите од убацивања кода (XSS рањивост) —
            //             није безбедно за продукцију
        p.printf("Корисник: %s %s%n",
                ime, prezime);
            p.printf("Email: %s%n", email);
        } else {
            p.println("Грешка");
            p.println("Молимо попуните сва поља.");
            p.println("Назад");
        }
 
        p.println("");
    }
}
