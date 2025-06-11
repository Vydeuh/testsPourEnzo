import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMain {

    // Tests sur les chaînes de caractères
    @Test
    public void testPalindromeRenvoieMotALEnvers() {
        String resultat = Main.palindrome("bouh");
        assertThat(resultat, containsString("huob"));
    }

    @Test
    public void testPalindromeRenvoiePalindrome() {
        String resultat = Main.palindrome("anna");
        assertThat(resultat, containsString("bien dit !"));
    }

    @Test
    public void testPlusieursMotsSontBienRenvoyesALEnvers() {
        String resultat = Main.palindrome("Bibi la Bibiste");
        assertThat(resultat, containsString("etsibiB al ibiB"));
    }

    @Test
    public void testBienDitALEnversDoitBienRenvoyerBienDit() {
        String resultat = Main.palindrome("! tid neib");
        assertThat(resultat, containsString("bien dit !"));
    }

    @Test
    public void testPalindromeCommenceParBonjourEtTermineParAuRevoirSiPasDePhrase() {
        String unePhrase = "";
        String resultat = Main.palindrome(unePhrase);
        assertEquals("Bonjour\n\nAu revoir", resultat);
    }

    @Test
    public void testPalindromeCommenceParBonjour() {
        String resultat = Main.palindrome("Salut");
        assertThat(resultat, startsWith("Bonjour\n"));
    }

    @Test
    public void testPalindromeTermineParAuRevoir() {
        String resultat = Main.palindrome("Salut");
        assertThat(resultat, endsWith("\nAu revoir"));
    }

    // Tests sur l'heure
    @Test
    public void testPalindromeRenvoieBonjourDe6h00m01sA18h00m00s() {
        Main.INSTANT = Main.FIN_DE_NUIT.plusSeconds(1);
        String resultat = Main.palindrome("En journée");
        assertThat(resultat, containsString("Bonjour\n"));
    }

    @Test
    public void testPalindromeRenvoieEncoreBonjourA18h00Pile() {
        Main.INSTANT = Main.FIN_DU_JOUR;
        String resultat = Main.palindrome("En journée");
        assertThat(resultat, containsString("Bonjour\n"));
    }

    @Test
    public void testPalindromeRenvoieBonsoirDe18h00m01sA6h00m00s() {
        Main.INSTANT = Main.FIN_DU_JOUR.plusSeconds(1);
        String resultat = Main.palindrome("En soirée");
        assertThat(resultat, containsString("Bonsoir\n"));
    }

    @Test
    public void testPalindromeRenvoieEncoreBonsoirA6h00Pile() {
        Main.INSTANT = Main.FIN_DE_NUIT;
        String resultat = Main.palindrome("En journée");
        assertThat(resultat, containsString("Bonsoir\n"));
    }

    // Tests langues
    @Test
    public void testPalindromeRenvoieGoodMorning() {
        Main.LANGUE = Langue.EN;
        Main.INSTANT = Main.FIN_DE_NUIT.plusSeconds(1);
        String resultat = Main.palindrome("Day");
        assertThat(resultat, containsString("Good morning\n"));
        Main.LANGUE = Langue.FR;
    }

    @Test
    public void testPalindromeRenvoieGoodEvening() {
        Main.LANGUE = Langue.EN;
        Main.INSTANT = Main.FIN_DU_JOUR.plusSeconds(1);
        String resultat = Main.palindrome("Night");
        assertThat(resultat, containsString("Good evening\n"));
        Main.LANGUE = Langue.FR;
    }

    @Test
    public void testPalindromeRenvoieGoodBye() {
        Main.LANGUE = Langue.EN;
        String resultat = Main.palindrome("Hello");
        assertThat(resultat, endsWith("\nGood bye"));
        Main.LANGUE = Langue.FR;
    }

    @Test
    public void testPalindromeRenvoieWellSaid() {
        Main.LANGUE = Langue.EN;
        String resultat = Main.palindrome("bob");
        assertThat(resultat, containsString("well said !\n"));
        Main.LANGUE = Langue.FR;
    }
}

