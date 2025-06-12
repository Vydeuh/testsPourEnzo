import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Palindrome {

    static LocalTime FIN_DE_NUIT = LocalTime.of(6, 0, 0);
    static LocalTime FIN_DU_JOUR = LocalTime.of(18, 0, 0);
    static LocalTime INSTANT = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    static Langue LANGUE = Langue.FR;

    public Palindrome(Langue langue) {
        this.LANGUE = langue;
    }

    public String inverser(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();
        MessageBuilder message = new MessageBuilder(LANGUE);

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
        if(INSTANT.isAfter(FIN_DE_NUIT) && INSTANT.isBefore(FIN_DU_JOUR.plusSeconds(1))) {
            return message.bonjour();
        }
        return message.bonsoir();
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
}
