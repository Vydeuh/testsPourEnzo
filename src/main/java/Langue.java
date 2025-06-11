public enum Langue {
    FR("Bonjour", "Bonsoir", "Au revoir", "bien dit !"),
    EN("Good morning", "Good evening", "Good bye", "well said !");

    private final String bonjour, bonsoir, auRevoir, bienDit;

    Langue(String bonjour, String bonsoir, String auRevoir, String bienDit) {
        this.bonjour = bonjour;
        this.bienDit = bienDit;
        this.auRevoir = auRevoir;
        this.bonsoir = bonsoir;
    }

    public String bonjour() { return this.bonjour; }
    public String bonsoir() { return this.bonsoir; }
    public String bienDit() { return bienDit; }
    public String auRevoir() { return auRevoir; }
}
