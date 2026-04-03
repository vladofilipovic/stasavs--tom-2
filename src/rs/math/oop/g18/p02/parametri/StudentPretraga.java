package rs.math.oop.g18.p02.parametri;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentPretraga {
 
    // Параметар из путање
    // GET /api/studenti/indeks/2021/0001
    @GET
    @Path("/indeks/{godina}/{broj}")
    public Response poIndeksu(
        @PathParam("godina") String godina,
        @PathParam("broj") String broj) {
        String indeks = godina + "/" + broj;
        // Претрага...
        return Response.ok().build();
    }
 
    // Параметри из упита
    // GET /api/studenti/pretraga?minProsek=9.0&status=AKTIVAN
    @GET
    @Path("/pretraga")
    public List pretraga(
        @QueryParam("minProsek")
            @DefaultValue("0.0") Double minProsek,
        @QueryParam("status") String status,
        @QueryParam("stranica")
            @DefaultValue("1") int stranica,
        @QueryParam("velicina")
            @DefaultValue("10") int velicina) {
 
        // Филтрирање и пагинација
        return List.of(); // плејсхолдер
    }
 
    // Параметар из заглавља
    @GET
    @Path("/info")
    public Response info(
        @HeaderParam("Accept-Language") String jezik,
        @HeaderParam("Authorization") String token) {
 
        if (token == null || !token.startsWith("Bearer ")) {
            return Response
            .status(Response.Status.UNAUTHORIZED)
            .entity(Map.of("greska", "Потребна " +
                "аутентификација"))
            .build();
        }
        return Response.ok().build();
    }
}
