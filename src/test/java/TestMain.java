import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMain {

    @Test
    public void testPalindromeRenvoitMotALEnvers() {
        String unePhrase = "bouh";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("huob", resultat);
    }

    @Test
    public void testPalindromeRenvoitPalindrome() {
        String unePhrase = "anna";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("bien dit !", resultat);
    }

    @Test
    public void testChaineVideRenvoitPalindromeParDefaut() {
        String unePhrase = "";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("bien dit !", resultat);
    }

}

