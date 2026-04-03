package rs.math.oop.g18.p03.obradaGresaka;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class ResursNijeNadjenMapper
    implements ExceptionMapper<ResursNijeNadjenException> {
 
    @Override
    public Response toResponse(
        ResursNijeNadjenException e) {
        return Response
        .status(Response.Status.NOT_FOUND)
        .entity(Map.of(
            "greska", e.getMessage(),
            "kod", 404,
            "id", e.getId()
        ))
        .build();
    }
}
