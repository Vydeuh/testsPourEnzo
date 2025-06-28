import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Palindrome {

    private static final LocalTime FIN_DE_NUIT = LocalTime.of(6, 0, 0);
    private static final LocalTime FIN_DU_MATIN = LocalTime.of(12, 0, 0);
    private static final LocalTime FIN_DU_JOUR = LocalTime.of(18, 0, 0);
    private static final LocalTime MINUIT = LocalTime.MIDNIGHT;

    private LocalTime instant;
    private final Langue langue;
    private MessageBuilder message;

    public Palindrome(Langue langue) {
        this.langue = langue;
        this.instant = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.message = new MessageBuilder(this);
    }

    public String inverser(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();

        message = bonjour(message);
        if (maPhrase.equals(reponse)) {
            message = bienDit(message);
        } else {
            message = contenu(message, reponse);
        }
        message = auRevoir(message);
        return message.build();
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
        return langue;
    }

    public LocalTime getHeure() {
        return instant;
    }

    public void setHeure(LocalTime heure) {
        this.instant = heure;
    }
    
    public MessageBuilder getMessage() {
    	return this.message;
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

    public static LocalTime getMinuit() {
        return MINUIT;
    }
}