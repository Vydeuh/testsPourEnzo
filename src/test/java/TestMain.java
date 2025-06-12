import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMain {

    private Palindrome palindrome;

    @BeforeEach
    public void setUp() {
        palindrome = new Palindrome(Langue.FR);
    }

    // Tests sur les chaînes de caractères
    @Test
    public void testPalindromeRenvoieMotALEnvers() {
        // ETANT DONNE un mot qui n'est pas un palindrome
        String mot = "bouh";
        // QUAND on donne ce mot à la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le mot est inversé
        assertThat(resultat, containsString("huob"));
    }

    @Test
    public void testPalindromeRenvoiePalindrome() {
        // ETANT DONNE un mot qui est un palindrome
        String mot = "anna";
        // QUAND on donne ce mot à la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS un message spécial reconnaissant le palindrome est envoyé
        assertThat(resultat, containsString(palindrome.getLangue().bienDit()));
    }

    @Test
    public void testPlusieursMotsSontBienRenvoyesALEnvers() {
        // ETANT DONNE un ensemble de mots qui ne forment pas un palindrome
        String phrase = "Bibi la Bibiste";
        // QUAND on donne cette phrase à la méthode inverser
        String resultat = palindrome.inverser(phrase);
        // ALORS la phrase est inversée
        assertThat(resultat, containsString("etsibiB al ibiB"));
    }

    @Test
    public void testBienDitALEnversDoitBienRenvoyerBienDit() {
        // ETANT DONNE le message spécial reconnaissant le palindrome
        StringBuilder motSpecial = new StringBuilder(palindrome.getLangue().bienDit()).reverse();
        String motSpecialInverse = motSpecial.toString();
        // QUAND on donne ce mot spécial à la méthode inverser
        String resultat = palindrome.inverser(motSpecialInverse);
        // ALORS le mot spécial est envoyé
        assertThat(resultat, containsString(palindrome.getLangue().bienDit()));
    }

    @Test
    public void testPalindromeCommenceParBonjour() {
        // ETANT DONNE un mot qui est ou non un palindrome
        String mot = "bouh";
        // QUAND on donne ce mot à la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le premier mot envoyé est le message de bienvenue
        assertThat(resultat, startsWith(palindrome.getLangue().bonjour()));
    }

    @Test
    public void testPalindromeTermineParAuRevoir() {
        // ETANT DONNE un mot qui est ou non un palindrome
        String mot = "bouh";
        // QUAND on donne ce mot à la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le dernier mot envoyé est le message d'au revoir
        assertThat(resultat, endsWith(palindrome.getLangue().auRevoir()));
    }

    // Tests sur l'heure
    @Test
    public void testPalindromeRenvoieBonjourDe6h00m01sA18h00m00s() {
        // ETANT DONNE un horaire de jour
        // ET un mot qui est ou non un palindrome
        Palindrome.INSTANT = Palindrome.FIN_DE_NUIT.plusSeconds(1);
        String mot = "En journée";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui du jour
        assertThat(resultat, containsString(palindrome.getLangue().bonjour()));
    }

    @Test
    public void testPalindromeRenvoieEncoreBonjourA18h00Pile() {
        // ETANT DONNE le dernier instant du jour
        // ET un mot qui est ou non un palindrome
        Palindrome.INSTANT = Palindrome.FIN_DU_JOUR;
        String mot = "En journée";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui du jour
        assertThat(resultat, containsString(palindrome.getLangue().bonjour()));
    }

    @Test
    public void testPalindromeRenvoieBonsoirDe18h00m01sA6h00m00s() {
        // ETANT DONNE un horaire de nuit
        // ET un mot qui est ou non un palindrome
        Palindrome.INSTANT = Palindrome.FIN_DU_JOUR.plusSeconds(1);
        String mot = "En soirée";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui du soir
        assertThat(resultat, containsString(palindrome.getLangue().bonsoir()));
    }

    @Test
    public void testPalindromeRenvoieEncoreBonsoirA6h00Pile() {
        // ETANT DONNE le dernier instant du soir
        // ET un mot qui est ou non un palindrome
        Palindrome.INSTANT = Palindrome.FIN_DE_NUIT;
        String mot = "En soirée";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui du soir
        assertThat(resultat, containsString(palindrome.getLangue().bonsoir()));
    }
}

