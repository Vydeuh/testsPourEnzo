public class Main {

    public static void main(String[] args) {
        String maPhrase = "salut";
        Langue langue = Langue.FR;
        Palindrome palindrome = new Palindrome(langue);
        System.out.println(palindrome.inverser(maPhrase));
    }
}

