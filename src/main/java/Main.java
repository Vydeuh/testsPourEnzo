import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        String maPhrase = "salut";
        System.out.println(palindrome(maPhrase));
    }

    static LocalTime FIN_DE_NUIT = LocalTime.of(6, 0, 0);
    static LocalTime FIN_DU_JOUR = LocalTime.of(18, 0, 0);
    static LocalTime INSTANT = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

    public static String palindrome(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();
        if(maPhrase.isEmpty()) {
            return bonjour() + auRevoir();
        }
        else if (maPhrase.equals(reponse)) {
            return bonjour() + "bien dit !" + auRevoir();
        } else {
            return bonjour() + reponse + auRevoir();
        }
    }

    private static String bonjour() {
        if(INSTANT.isAfter(FIN_DE_NUIT) && INSTANT.isBefore(FIN_DU_JOUR.plusSeconds(1))) {
            return "Bonjour\n";
        }
        return "Bonsoir\n";
    }

    private static String auRevoir() {
        return "\nAu revoir";
    }
}

