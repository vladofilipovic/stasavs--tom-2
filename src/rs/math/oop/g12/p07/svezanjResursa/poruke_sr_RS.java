package rs.math.oop.g12.p07.svezanjResursa;

import java.util.ListResourceBundle;

public class poruke_sr_RS
    extends ListResourceBundle {
 
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            {"greeting", "Здраво"},
            {"farewell", "Довиђења"},
            {"app.title", "Моја апликација"},
            {"max.items", 100},
            {"colors", new String[]{
                    "црвена", "зелена", "плава"}}
        };
    }
}
