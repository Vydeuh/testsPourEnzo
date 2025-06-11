public class MessageBuilder {
    private final StringBuilder sb = new StringBuilder();
    private final Langue langue;

    public MessageBuilder(Langue langue) {
        this.langue = langue;
    }

    public MessageBuilder bonjour() {
        sb.append(langue.bonjour()).append("\n");
        return this;
    }

    public MessageBuilder bonsoir() {
        sb.append(langue.bonsoir()).append("\n");
        return this;
    }

    public MessageBuilder auRevoir() {
        sb.append("\n").append(langue.auRevoir());
        return this;
    }

    public MessageBuilder contenu(String texte) {
        sb.append(texte);
        return this;
    }

    public MessageBuilder bienDit() {
        sb.append(langue.bienDit());
        return this;
    }

    public String build() {
        return sb.toString();
    }
}

