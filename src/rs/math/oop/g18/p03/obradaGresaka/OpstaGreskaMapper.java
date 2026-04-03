package rs.math.oop.g18.p03.obradaGresaka;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class OpstaGreskaMapper
    implements ExceptionMapper<Exception> {
 
    @Override
    public Response toResponse(Exception e) {
        return Response
        .status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(Map.of(
            "greska", "Интерна грешка сервера",
            "kod", 500
        ))
        .build();
    }
}
