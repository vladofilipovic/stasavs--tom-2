package rs.math.oop.g08.p03.ogranicenaOsobina;

import java.beans.PropertyEditorSupport;

public class PolEditor
    extends PropertyEditorSupport {

    private static final String[] OPCIJE =
        {"Мушки", "Женски"};

    @Override
    public String[] getTags() {
        return OPCIJE;
    }

    @Override
    public String getAsText() {
        return (String) getValue();
    }

    @Override
    public void setAsText(String text) {
        for (String opcija : OPCIJE) {
            if (opcija.equals(text)) {
                setValue(text);
                return;
            }
        }
        throw new IllegalArgumentException(
            "Непозната вредност: " + text);
    }
}
