public enum Langue {
    FR("Bonjour", "Bonjour", "Bonsoir", "Bonne nuit", "Au revoir", "bien dit !"),
    EN("Good morning", "Good afternoon", "Good evening", "Good night", "Good bye", "well said !");

    private final String bonjourMatin;
    private final String bonjourApresMidi;
    private final String bonsoir;
    private final String bonneNuit;
    private final String auRevoir;
    private final String bienDit;

    Langue(String bonjourMatin, String bonjourApresMidi, String bonsoir, String bonneNuit, String auRevoir, String bienDit) {
        this.bonjourMatin = bonjourMatin;
        this.bonjourApresMidi = bonjourApresMidi;
        this.bonsoir = bonsoir;
        this.bonneNuit = bonneNuit;
        this.auRevoir = auRevoir;
        this.bienDit = bienDit;
    }

    public String bonjourMatin() { return this.bonjourMatin; }
    public String bonjourApresMidi() { return this.bonjourApresMidi; }
    public String bonsoir() { return this.bonsoir; }
    public String bienDit() { return bienDit; }
    public String auRevoir() { return auRevoir; }
    public String bonneNuit() { return bonneNuit; }
}
