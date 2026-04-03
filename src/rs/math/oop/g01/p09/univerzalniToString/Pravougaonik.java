package rs.math.oop.g01.p09.univerzalniToString;

import java.lang.reflect.*;

class Pravougaonik {
    private Tacka gornjeLevo, donjDesno;
    private String boja;
    public Pravougaonik(Tacka gl, Tacka dd, String boja) {
        this.gornjeLevo = gl;
        this.donjDesno = dd;
        this.boja = boja;
    }
}
