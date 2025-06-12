public class MessageBuilder {
    private final StringBuilder sb = new StringBuilder();
    private final Palindrome palindrome;

    public MessageBuilder(Palindrome palindrome) {
        this.palindrome = palindrome;
    }

    public MessageBuilder messageBienvenue() {
        if(palindrome.getHeure().isAfter(Palindrome.getFinDeNuit()) && palindrome.getHeure().isBefore(Palindrome.getFinDuMatin().plusSeconds(1))) {
            return this.bonjourMatin();
        }
        if(palindrome.getHeure().isAfter(Palindrome.getFinDuMatin()) && palindrome.getHeure().isBefore(Palindrome.getFinDuJour().plusSeconds(1))) {
            return this.bonjourApresMidi();
        }
        if(palindrome.getHeure().isAfter(Palindrome.getFinDuJour()) && palindrome.getHeure().isBefore(Palindrome.getFinDuSoir().plusSeconds(1))) {
            return this.bonsoir();
        }
        return this.bonneNuit();
    }

    public MessageBuilder bonjourMatin() {
        sb.append(this.bonjourMatin()).append("\n");
        return this;
    }

    public MessageBuilder bonjourApresMidi() {
        sb.append(this.bonjourApresMidi()).append("\n");
        return this;
    }

    public MessageBuilder bonsoir() {
        sb.append(this.bonsoir()).append("\n");
        return this;
    }

    public MessageBuilder bonneNuit() {
        sb.append(this.bonneNuit()).append("\n");
        return this;
    }

    public MessageBuilder auRevoir() {
        sb.append("\n").append(this.auRevoir());
        return this;
    }

    public MessageBuilder contenu(String texte) {
        sb.append(texte);
        return this;
    }

    public MessageBuilder bienDit() {
        sb.append(this.bienDit());
        return this;
    }

    public String build() {
        return sb.toString();
    }
}

