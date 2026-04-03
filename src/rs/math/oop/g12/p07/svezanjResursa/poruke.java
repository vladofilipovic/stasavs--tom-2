package rs.math.oop.g12.p07.svezanjResursa;

import java.util.ListResourceBundle;

public class poruke
    extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            {"greeting", "Hello"},
            {"farewell", "Goodbye"},
            {"app.title", "My Application"},
            {"max.items", 100},
            {"colors", new String[]{
                    "red", "green", "blue"}}
        };
    }
}
