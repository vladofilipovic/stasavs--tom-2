package rs.math.oop.g12.p07.svezanjResursa;

import java.util.*;

public class Primer07_SvezanjResursa {
    public static void main(String[] args) {
        // Учитавање за српски локалитет
        Locale srpski = new Locale("sr", "RS");
        ResourceBundle rb = ResourceBundle
        .getBundle("rs.math.oop.g12.p07.svezanjResursa.poruke", srpski);

        System.out.println(
        rb.getString("greeting"));
        System.out.println(
        rb.getString("farewell"));
        System.out.println(
        rb.getString("app.title"));

        // Учитавање за енглески локалитет
        ResourceBundle rbEn = ResourceBundle
        .getBundle("rs.math.oop.g12.p07.svezanjResursa.poruke", Locale.US);

        System.out.println(
        rbEn.getString("greeting"));
        System.out.println(
        rbEn.getString("farewell"));

        // Листа свих кључева
        System.out.println(
        "Кључеви: "
        + Collections.list(rb.getKeys()));
    }
}
