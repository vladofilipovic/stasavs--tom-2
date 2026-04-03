package rs.math.oop.g13.p09.tddUPraksi;


public class EmailValidator {
 
    public boolean jeValidan(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Провера да садржи тачно један @ знак
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) {
            return false;
        }
        // Провера домена
        String domen = email.substring(atIndex + 1);
        if (domen.isEmpty() || domen.startsWith(".") ||
            !domen.contains(".")) {
            return false;
        }
        // Провера да нема размака
        if (email.contains(" ")) {
            return false;
        }
        return true;
    }
}
