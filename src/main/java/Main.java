import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        String maPhrase = "salut";
        String heure = obtenirHeure();
        System.out.println(bonjour());
        System.out.println(palindrome(maPhrase));
        System.out.println(auRevoir());
        System.out.println(heure);
    }

    public static String palindrome(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();
        if(maPhrase.equals("")) {
            return bonjour() + auRevoir();
        }
        else if (maPhrase.equals(reponse)) {
            return bonjour() + "bien dit !" + auRevoir();
        } else {
            return bonjour() + reponse + auRevoir();
        }
    }

    public static String obtenirHeure() {
        LocalTime heure = LocalTime.now();
        DateTimeFormatter heureFormatee = DateTimeFormatter.ofPattern("HH:mm:ss");
        return heure.format(heureFormatee);
    }

    private static String bonjour() {
        return "Bonjour\n";
    }

    private static String auRevoir() {
        return "\nAu revoir";
    }
}

