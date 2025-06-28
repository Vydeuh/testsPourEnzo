import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
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
    public void testPalindromeRenvoieUnPalindrome() {
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
        assertThat(resultat, startsWith(palindrome.getMessage().build()));
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
    public void testPalindromeRenvoieFormuleBonjourDuMatinDe6h00m01sA12h00m00s() {
        // ETANT DONNE un horaire de matin
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getFinDeNuit().plusSeconds(1));
        String mot = "Le matin";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui du matin
        assertThat(resultat, containsString(palindrome.getLangue().bonjourMatin()));
    }

    @Test
    public void testPalindromeRenvoieEncoreFormuleBonjourDuMatinA12h00Pile() {
        // ETANT DONNE le dernier instant du matin
        // ET un mot qui est ou non un palindrome
    	palindrome.setHeure(Palindrome.getFinDuMatin());
        String mot = "Le matin";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui du matin
        assertThat(resultat, containsString(palindrome.getLangue().bonjourMatin()));
    }

    @Test
    public void testPalindromeRenvoieFormuleBonjourDeApresMidiDe12h00m01sA18h00m00s() {
        // ETANT DONNE un horaire d'après-midi
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getFinDuMatin().plusSeconds(1));
        String mot = "Après-midi";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui de l'après-midi
        assertThat(resultat, containsString(palindrome.getLangue().bonjourApresMidi()));
    }

    @Test
    public void testPalindromeRenvoieEncoreFormuleBonjourDeApresMidiA18h00Pile() {
        // ETANT DONNE le dernier instant de l'après-midi
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getFinDuJour());
        String mot = "Après-midi";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui de l'après-midi
        assertThat(resultat, containsString(palindrome.getLangue().bonjourApresMidi()));
    }

    @Test
    public void testPalindromeRenvoieFormuleBonsoirDe18h00m01sA00h00m00s() {
        // ETANT DONNE un horaire du soir
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getFinDuJour().plusSeconds(1));
        String mot = "Soir";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui du soir
        assertThat(resultat, containsString(palindrome.getLangue().bonsoir()));
    }

    @Test
    public void testPalindromeRenvoieEncoreFormuleBonsoirA00h00Pile() {
        // ETANT DONNE le dernier instant de la soirée
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getMinuit());
        String mot = "Soir";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui du soir
        assertThat(resultat, containsString(palindrome.getLangue().bonsoir()));
    }

    @Test
    public void testPalindromeRenvoieFormuleBonneNuitDe00h00m01sA06h00m00s() {
        // ETANT DONNE un horaire de nuit
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getMinuit().plusSeconds(1));
        String mot = "Nuit";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond à celui de la nuit
        assertThat(resultat, containsString(palindrome.getLangue().bonneNuit()));
    }

    @Test
    public void testPalindromeRenvoieEncoreFormuleBonneNuitA06h00Pile() {
        // ETANT DONNE le dernier instant de la nuit
        // ET un mot qui est ou non un palindrome
        palindrome.setHeure(Palindrome.getFinDeNuit());
        String mot = "Nuit";
        // QUAND on appelle la méthode inverser
        String resultat = palindrome.inverser(mot);
        // ALORS le message de bienvenue correspond encore à celui de la nuit
        assertThat(resultat, containsString(palindrome.getLangue().bonneNuit()));
    }
}