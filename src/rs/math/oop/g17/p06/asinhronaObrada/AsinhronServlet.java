package rs.math.oop.g17.p06.asinhronaObrada;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/izvestaj",
    asyncSupported = true)
public class AsinhronServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest zahtev,
        HttpServletResponse odgovor)
        throws IOException {
 
        odgovor.setContentType("text/html; charset=UTF-8");
 
        // Покретање асинхроне обраде
        AsyncContext async = zahtev.startAsync();
        async.setTimeout(30000); // 30 секунди
 
        // Обрада у посебној нити
        async.start(() -> {
            try {
                PrintWriter p = async.getResponse()
                    .getWriter();
 
                p.println("Генерисање извештаја...");
                p.flush();
 
                // Симулација дуготрајне операције
                Thread.sleep(3000);
 
                p.println("Извештај генерисан.");
 
                // Завршавање асинхроне обраде
                async.complete();
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
