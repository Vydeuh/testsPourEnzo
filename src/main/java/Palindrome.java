import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Palindrome {

    static LocalTime FIN_DE_NUIT = LocalTime.of(6, 0, 0);
    static LocalTime FIN_DU_JOUR = LocalTime.of(18, 0, 0);
    static LocalTime FIN_DU_MATIN = LocalTime.of(12, 0, 0);
    static LocalTime FIN_DU_SOIR = LocalTime.of(0, 0, 0);
    static LocalTime INSTANT;
    static Langue LANGUE = Langue.FR;

    public Palindrome(Langue langue) {
        this.LANGUE = langue;
        this.INSTANT = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public String inverser(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();
        MessageBuilder message = new MessageBuilder(this);

        if(maPhrase.isEmpty()) {
            message = bonjour(message);
            message = auRevoir(message);
            return message.build();
        }
        else if (maPhrase.equals(reponse)) {
            message = bonjour(message);
            message = bienDit(message);
            message = auRevoir(message);
            return message.build();
        } else {
            message = bonjour(message);
            message = contenu(message, reponse);
            message = auRevoir(message);
            return message.build();
        }
    }

    private static MessageBuilder bonjour(MessageBuilder message) {
        return message.messageBienvenue();
    }

    private static MessageBuilder auRevoir(MessageBuilder message) {
        return message.auRevoir();
    }

    private static MessageBuilder contenu(MessageBuilder message, String maPhraseInversee) {
        return message.contenu(maPhraseInversee);
    }

    private static MessageBuilder bienDit(MessageBuilder message) {
        return message.bienDit();
    }

    public Langue getLangue() {
        return LANGUE;
    }

    public LocalTime getHeure() {
        return INSTANT;
    }

    public static LocalTime getFinDeNuit() {
        return FIN_DE_NUIT;
    }

    public static LocalTime getFinDuJour() {
        return FIN_DU_JOUR;
    }

    public static LocalTime getFinDuMatin() {
        return FIN_DU_MATIN;
    }

    public static LocalTime getFinDuSoir() {
        return FIN_DU_SOIR;
    }
}
