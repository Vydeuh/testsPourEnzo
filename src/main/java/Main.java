public class Main {

    public static void main(String[] args) {
        String maPhrase = "salut";
        System.out.println(bonjour());
        System.out.println(palindrome(maPhrase));
        System.out.println(auRevoir());
        //System.out.println(bonjourAuRevoir(maPhrase));
    }

    public static String palindrome(String maPhrase) {
        StringBuilder inverse = new StringBuilder(maPhrase).reverse();
        String reponse = inverse.toString();
        if (maPhrase.equalsIgnoreCase(reponse)) {
            return "bien dit !";
        } else {
            return reponse;
        }
    }

    public static String bonjour() {
        return "Bonjour !";
    }

    public static String auRevoir() {
        return "Au revoir !";
    }

	/*public static String bonjourAuRevoir(String maPhrase) {
		String bonjour = "Bonjour !\n";
		String auRevoir = "Au revoir !";
		String palindrome = palindrome(maPhrase);
		return bonjour + palindrome + "\n" + auRevoir;
	}*/

}

