
/*
 * Classe qui représente une personne.
 * Personne.java                                                        09/09/21
 */

package LaClassePersonne;
import java.util.Scanner;

/**
 * Classe décrivant une personne avec comme caractéristiques :
 *    un nom et un prénom hérités de la classe Individu
 *    un numéro de téléphone
 *    une adresse électronique
 *
 * @author guillaume helg
 * @version 1.0
 */
public class Personne extends Individu {


    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);

    /**
     * constante pour l'adresse électronique par défaut
     */
    private static final String MAIL_DEFAUT = "inconnu@inconnu";


    /**
     * Attribut adresse électronique
     */
    private String email;


    /**
     * Attribut numéro de téléphone
     */
    private Telephone tel;

    public Personne() {
        super();
        this.email = MAIL_DEFAUT;
        this.tel = new Telephone();
    }

    /**
     * Constructeur avec en paramètre le nom et le prénom. Le téléphone et
     * l'adresse mail sont initialisés par défaut
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     */
    public Personne(String leNom, String lePrenom) {
        super(leNom, lePrenom);         // appel au constructeur de Individu
        this.tel = new Telephone();          // création du numéro de téléphone
        // (initialisé avec la valeur par défaut)
        this.email = MAIL_DEFAUT;            // affectation du mail par défaut
    }

    public Personne(String leNom, String lePrenom, String leNumero, String leEmail) {

        super(leNom, lePrenom);         // appel au constructeur de Individu
        this.tel = new Telephone(leNumero);         // création du numéro de téléphone
        // (initialisé avec la valeur par défaut)
        if(!mailValide(leEmail)) {
            throw new IllegalArgumentException("aie aie aie");
        } else {
            this.email = leEmail;

        }


    }

    public void afficher() {
        System.out.println(super.toString() + "\n" + this.tel.getNumero() + "\n" + this.email);
    }

    /**
     * Effectue la saisie des caractéristiques de la personne.
     * La saisie du numéro de téléphone et de l'adresse électronique
     * est recommencée en cas d'erreur
     */
    @Override
    public void saisir() {
        super.saisir();         // saisie du nom et du prénom

        // saisie de l'adresse mail
        do {            // on recommence la saisie si erreur
            System.out.print("email ............: ");
            email = entree.nextLine();
        } while (!mailValide(email));

        tel.saisir(); // saisie du numéro de téléphone
    }

    public String Information() {
        return super.toString() + "\n" + this.tel.getNumero() + "\n" + this.email;
    }


    /**
     * Détermine si la chaîne argument contient une adresse mail valide :
     *   des lettres, des chiffres, l'un des caractères '-' '_' '.'
     *   le symbole '@'
     *   des lettres, des chiffres, l'un des caractères '-' '_'
     *   un point '.'
     *   puis 2 ou 3 lettres
     * @param chaine à tester
     * @return vrai ssi la chaîne contient une adresse valide
     */
    public static boolean mailValide(String chaine) {

        String regexMail = "[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,3}$";


        //String regexMail = "[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}$""

        return chaine.matches(regexMail);

    }
}



