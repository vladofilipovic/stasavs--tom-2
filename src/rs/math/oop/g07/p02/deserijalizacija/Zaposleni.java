package rs.math.oop.g07.p02.deserijalizacija;

import java.io.*;

class Zaposleni implements Externalizable {
    private String ime;
    private int godine;

    // Подразумевани конструктор је обавезан
    public Zaposleni() {}

    public Zaposleni(String ime, int godine) {
        this.ime = ime;
        this.godine = godine;
    }

    @Override
    public void writeExternal(ObjectOutput oo)
            throws IOException {
        oo.writeUTF(ime);
        oo.writeInt(godine);
    }

    @Override
    public void readExternal(ObjectInput oi)
            throws IOException,
                   ClassNotFoundException {
        ime = oi.readUTF();
        godine = oi.readInt();
    }

    @Override
    public String toString() {
        return ime + " (" + godine + ")";
    }
}
