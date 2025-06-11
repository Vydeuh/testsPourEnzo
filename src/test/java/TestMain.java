import org.junit.Test;

import static org.junit.Assert.*;

public class TestMain {

    @Test
    public void testPalindromeRenvoitMotALEnvers() {
        String unePhrase = "bouh";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\nhuob\nAu revoir", resultat);
    }

    @Test
    public void testPalindromeRenvoitPalindrome() {
        String unePhrase = "anna";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\nbien dit !\nAu revoir", resultat);
    }

    @Test
    public void testPlusieursMotsSontBienRenvoyesALEnvers() {
        String unePhrase = "Bibi la Bibiste";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\netsibiB al ibiB\nAu revoir", resultat);
    }

    @Test
    public void testBienDitALEnversDoitBienRenvoyerBienDit() {
        String unePhrase = "! tid neib";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\nbien dit !\nAu revoir", resultat);
    }

    @Test
    public void testUnNonPalindromeNeRenvoitPasBienDit() {
        String unePhrase = "Salut";
        String resultat = Main.palindrome(unePhrase);
        assertNotEquals("Bonjour\nbien dit !\nAu revoir", resultat);
    }

    @Test
    public void testPalindromeCommenceParBonjourEtTermineParAuRevoirSiPasDePhrase() {
        String unePhrase = "";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\n\nAu revoir", resultat);
    }
}

