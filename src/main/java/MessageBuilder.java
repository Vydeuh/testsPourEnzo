import java.time.LocalTime;

public class MessageBuilder {
	
    private final StringBuilder sb = new StringBuilder();
    private final Palindrome palindrome;

    public MessageBuilder(Palindrome palindrome) {
        this.palindrome = palindrome;
    }

    public MessageBuilder messageBienvenue() {
        LocalTime heure = palindrome.getHeure();

        if (heure.isAfter(Palindrome.getFinDeNuit()) && !heure.isAfter(Palindrome.getFinDuMatin())) {
            return bonjourMatin();
        }
        if (heure.isAfter(Palindrome.getFinDuMatin()) && !heure.isAfter(Palindrome.getFinDuJour())) {
            return bonjourApresMidi();
        }
        if (heure.isAfter(Palindrome.getFinDuJour()) || heure.equals(Palindrome.getMinuit())) {
            return bonsoir();
        }
        return bonneNuit();
    }

    public MessageBuilder bonjourMatin() {
        sb.append(palindrome.getLangue().bonjourMatin()).append("\n");
        return this;
    }

    public MessageBuilder bonjourApresMidi() {
        sb.append(palindrome.getLangue().bonjourApresMidi()).append("\n");
        return this;
    }

    public MessageBuilder bonsoir() {
        sb.append(palindrome.getLangue().bonsoir()).append("\n");
        return this;
    }

    public MessageBuilder bonneNuit() {
        sb.append(palindrome.getLangue().bonneNuit()).append("\n");
        return this;
    }

    public MessageBuilder auRevoir() {
        sb.append("\n").append(palindrome.getLangue().auRevoir());
        return this;
    }

    public MessageBuilder contenu(String texte) {
        sb.append(texte);
        return this;
    }

    public MessageBuilder bienDit() {
        sb.append(palindrome.getLangue().bienDit());
        return this;
    }

    public String build() {
        return sb.toString();
    }
}