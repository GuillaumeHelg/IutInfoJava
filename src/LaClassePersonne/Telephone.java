/* Classe qui gère un numéro de téléphone
 * Telephone.java                                               09/09/14
 */

package LaClassePersonne;
import java.util.Scanner;

/**
 * Gestion d'un numéro de téléphone, avec comme possibilités principales :
 * création, saisie, affichage d'un numéro de téléphone.
 * Un numéro est considéré comme valide s'il comporte 10 chiffres.
 *
 * @author INFO2
 * @version 1.0
 */
public class Telephone  {

    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);

    /** Constante égale au nombre de chiffres d'un numéro de téléphone */
    private final static int NB_CHIFFRE = 10;

    /** Constante égale au numéro de téléphone par défaut */
    private final static String NUM_DEFAUT = "0000000000";


    /**
     * Attribut contenant le numéro de téléphone
     */
    private String numero;


    /**
     * Constructeur par défaut (initialisation avec la constante NUM_DEFAUT)
     */
    public Telephone() {
        numero = NUM_DEFAUT;
    }

    /**
     * Constructeur avec en argument le numéro de téléphone. Si celui-ci est
     * invalide, c'est le numéro par défaut qui est affecté
     * @param s  chaîne contenant le numéro de téléphone
     */
    public Telephone(String s) {
        numero = s;
        if (!valide())              // si le numéro n'est pas valide
            numero = NUM_DEFAUT;    // affectation avec le numéro par défaut
    }

    /**
     * Détermine si le numéro courant est valide, c'est-à-dire contient 10
     * chiffres
     * @return un booléen égal à vrai ssi le numéro est valide
     */
    private boolean valide() {
        if (numero == null || numero.length() != NB_CHIFFRE) {

            // nombre de chiffres incorrect
            return false;
        } else {
            int i;

            // on vérifie que le numéro ne contient que des chiffres
            for (i = 0; i < NB_CHIFFRE && numero.charAt(i) >= '0'
                    && numero.charAt(i) <= '9'; i++);

            // si on a parcouru toute la chaîne, le numéro est valide
            return i == NB_CHIFFRE;
        }
    }

    /**
     * Affiche le numéro de téléphone sur la sortie standard
     */
    public void afficher() {
        System.out.print(numero);
    }

    /**
     * Accesseur sur le numéro
     * @return une chaîne contenant le numéro de téléphone
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Saisit le numéro. La saisie est recommencée en cas d'erreur.
     */
    public void saisir() {

        boolean correct = false; // vrai ssi le numéro saisi est correct

        // la saisie du numéro est recommencée jusqu'à obtenir un numéro correct
        do {
            System.out.print("Telephone ? ");
            numero = entree.nextLine();         // lecture de la chaîne numéro
            correct = valide();                 // test de la validité du numéro
            if (!correct) {             // si numéro incorrect : message d'erreur
                System.out.println("Numero invalide. Recommencez ! ");
            }
        } while (!correct);
    }

}