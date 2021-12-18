/* Classe qui représente un individu (nom + prénom)
 * Individu.java                                                            09/09/14
 */

package LaClassePersonne;
import java.util.Scanner;

/**
 * Classe qui représente un individu décrit par son nom et son prénom
 *
 * @author INFO2
 * @version 1.0
 */
public class Individu {


    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);

    /** constante pour initialiser par défaut les attributs */
    private static final String DEFAUT = "inconnu";

    /** attribut nom de l'individu */
    private String nom;

    /** attribut prénom de l'individu */
    private String prenom;


    /**
     * Constructeur avec les valeurs par défaut
     */
    public Individu() {
        nom = prenom = DEFAUT;
    }

    /**
     * Constructeur qui initialise les attributs à partir des arguments
     * Si un argument contient une chaîne vide, c'est la valeur par défaut qui
     * est affectée
     * @param leNom    le nom de l'individu
     * @param lePrenom le prénom de l'individu
     */
    public Individu(String leNom, String lePrenom) {
        nom = (leNom == null || leNom.length() == 0 ? DEFAUT : leNom.trim());
        prenom = (lePrenom == null || lePrenom.length() == 0 ? DEFAUT : lePrenom.trim());
    }

    /**
     * Renvoie le nom et le prénom
     * @return une chaîne de caractères contenant le nom et le prénom de la
     *         personne, séparés par un espace
     */
    public String toString() {
        return nom + " " + prenom;
    }

    /**
     * Affiche à l'écran le nom et le prénom de la personne
     */
    public void afficher() {
        System.out.println("Nom ........... : " + nom + '\n'
                + "Prenom ........ : " + prenom);
    }

    /**
     * Effectue la saisie du nom et du prénom de la personne
     * Si l'utilisateur entre une chaîne vide, c'est la valeur par
     * défaut qui est affectée à l'attribut
     */
    public void saisir() {

        // saisie du nom
        System.out.print("Nom ......... ? ");
        nom = entree.nextLine();
        nom = (nom.trim().length() == 0 ? DEFAUT : nom.trim());

        // saisie du prénom
        System.out.print("Prénom ...... ? ");
        prenom = entree.nextLine();
        prenom = (prenom.trim().length() == 0 ? DEFAUT : prenom.trim());
    }


    /**
     * Renvoie vrai ssi l'individu courant a le nom et le prénom argument.
     * Pas de distinction entre les minuscules et les majuscules
     * @param leNom        chaîne contenant le nom à comparer
     * @param lePrenom     chaîne contenant le prénom à comparer
     * @return vrai ssi l'individu a le nom et le prénom argument
     */
    public boolean est(String leNom, String lePrenom) {
        return nom.equalsIgnoreCase(leNom) && prenom.equalsIgnoreCase(lePrenom);
    }

}