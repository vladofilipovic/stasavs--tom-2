package rs.math.oop.g18.p01.osnovniResurs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Path("/api/studenti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResurs {
 
    // Симулација базе података
    private static final Map<Long, Student> baza =
        new ConcurrentHashMap<>();
    private static final AtomicLong generator =
        new AtomicLong(1);
 
    static {
        Student s1 = new Student(generator.getAndIncrement(),
        "Марко", "Марковић", "2021/0001", 9.15);
        Student s2 = new Student(generator.getAndIncrement(),
        "Јелена", "Јовановић", "2021/0002", 8.73);
        baza.put(s1.getId(), s1);
        baza.put(s2.getId(), s2);
    }
 
    // GET /api/studenti – сви студенти
    @GET
    public List<Student> sviStudenti() {
        return new ArrayList<>(baza.values());
    }
 
    // GET /api/studenti/{id} – један студент
    @GET
    @Path("/{id}")
    public Response nadjiStudenta(@PathParam("id") Long id) {
        Student s = baza.get(id);
        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND)
            .entity(Map.of("greska",
                "Студент " + id + " није пронађен"))
            .build();
        }
        return Response.ok(s).build();
    }
 
    // POST /api/studenti – креирање
    @POST
    public Response kreirajStudenta(Student student) {
        Long id = generator.getAndIncrement();
        student.setId(id);
        baza.put(id, student);
 
        return Response
        .status(Response.Status.CREATED)
        .entity(student)
        .build();
    }
 
    // PUT /api/studenti/{id} – ажурирање
    @PUT
    @Path("/{id}")
    public Response azurirajStudenta(
        @PathParam("id") Long id, Student student) {
        if (!baza.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
            .build();
        }
        student.setId(id);
        baza.put(id, student);
        return Response.ok(student).build();
    }
 
    // DELETE /api/studenti/{id} – брисање
    @DELETE
    @Path("/{id}")
    public Response obrisiStudenta(
        @PathParam("id") Long id) {
        Student uklonjeni = baza.remove(id);
        if (uklonjeni == null) {
            return Response.status(Response.Status.NOT_FOUND)
            .build();
        }
        return Response.noContent().build();
    }
}
