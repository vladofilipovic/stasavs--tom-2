package rs.math.oop.g18.p05.klijent;

import jakarta.validation.constraints.*;

public class StudentDTO {
 
    @NotNull(message = "Име је обавезно")
    @Size(min = 2, max = 50,
    message = "Име мора имати 2–50 знакова")
    private String ime;
 
    @NotNull(message = "Презиме је обавезно")
    private String prezime;
 
    @Pattern(regexp = "\\d{4}/\\d{4}",
    message = "Формат индекса: GGGG/BBBB")
    private String indeks;
 
    @Min(value = 6, message = "Минималан просек је 6")
    @Max(value = 10, message = "Максималан просек је 10")
    private Double prosek;
 
    // методи за приступање и постављање вредности...
}
