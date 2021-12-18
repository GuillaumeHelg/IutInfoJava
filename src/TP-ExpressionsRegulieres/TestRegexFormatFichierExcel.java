
/*
 * Test des expressions régulières utilisées dans les méthodes permettant
 * de vérifier qu'un fichier Excel est bien dans le format attendu
 * (un fichier contenant une liste d'étudiants et des notes)
 * TestRegexFormatFichierExcel.java                                 10/17
 */
package TP;

/**
 * Ce programme permet de tester 2 expressions régulières.
 * La première correspond à une chaîne de caractère contenant le nom et le prénom
 * d'une personne dans un format simplifié.
 * La deuxième corresond à une note comprise entre 0 et 20
 * @author INFO2
 * @version 1.0
 */
public class TestRegexFormatFichierExcel {


    /* Expression régulière qui correspond au contenu valide pour la première
     * colonne du fichier Excel, supposée contenir le nom et éventuellement prénom
     * d'une personne.
     * La colonne peut débuter par un ou plusieurs espaces (facultatif)
     * Ensuite on doit trouver une lettre majusucle
     * Puis ensuite, éventuellement, doivent se succéder des lettres (minuscules
     * ou majuscules, des traits d'union, des apostrophes. Ces caractères peuvent
     * être séparés par un ou plusieurs espaces.
     */
    private static final String REGEX_COLONNE_NOM = "( )*[A-Z]([a-z]|-|'| |)+( )*([A-Z]([a-z]|-|'| |)+)*( )*";


    /*
     * Expression régulière qui correspond à une note : entier compris entre 0 et 20
     */
    private static final String REGEX_COLONNE_NOTE = "( )*(\\d|1\\d|20)( )*";

    private static final String REGEX_PREMIERE_COLONNE = ".*([Nn][oO][mM]).*";


    /* Regex REGEX_COLONNE_NOM :  Jeu de tests avec des chaînes correctes */
    private static final String[] CHAINE_CORRECTE_COLONNE_NOM =
            { " Dupont", " Dupont Jacques ", "  De    Saint-Andre  " , "Cyprien d'Arc",
                    " De la Motte Saint-Pierre Marie-Amelie ", "Arthemis Dupont-Durand", "A"};

    /* Regex REGEX_COLONNE_NOM : Jeu de tests avec des chaînes incorrectes */
    private static final String[] CHAINE_INCORRECTE_COLONNE_NOM =
            { "  dupont", "      ", " Dupont3", "Dupont * ", " Dupont Jacques  789"};

    /* Regex REGEX_COLONNE_NOTE :  Jeu de tests avec des chaînes correctes */
    private static final String[] CHAINE_CORRECTE_COLONNE_NOTE =
            { "0", "20", "16", "   1     ", " 3", "4  ", "    16", "14  ", " 18  "};

    /* Regex REGEX_COLONNE_NOTE :  Jeu de tests avec des chaînes incorrectes */
    private static final String[] CHAINE_INCORRECTE_COLONNE_NOTE =
            { "", " ", "665", "   1  4     ", " 13   15", " 4  Z", "  A+ 10", "  A+  ",
                    "66", "09", "21", "26"};


    private static final String[] CHAINE_INCORRECTE_REGEX = {

    };



    /* Méthode de test d'une expression régulière
     * Les tests sont effectués avec des chaînes correctes et d'autres incorrectes.
     * Un rapport de test est affiché sur la console
     * @param message   message affiché avant les tests (il doit préciser quelle
     *                  expression régulière est testée)
     * @param regex     expression régulière à tester
     * @param donneeCorrecte   tableau contenant des chaînes supposées respecter le
     *                         format de la regex
     * @param donneeIncorrecte   tableau contenant des chaînes supposées ne pas respecter
     *                           le format de la regex
     */
    private static void testRegex(String message, String regex,
                                  String[] donneeCorrecte, String[] donneeIncorrecte) {
        int nbTestOk;       // nombre de tests corrects

        System.out.println("\n" + message +  " : \n");

        // on vérifie que les chaînes correctes sont bien évaluées à correct
        nbTestOk = 0;
        for (int i = 0; i < donneeCorrecte.length; i++) {
            if (!donneeCorrecte[i].matches(regex)) {
                System.out.println("ERREUR : La chaîne " + donneeCorrecte[i]
                        + " a été évaluée comme incorrecte.");
            } else {
                nbTestOk++;
            }
        }

        // on affiche un résumé des tests
        System.out.print("Résumé des tests avec chaînes correctes => ");
        if (nbTestOk == donneeCorrecte.length) {
            System.out.println("Tous tests sont OK");
        } else {
            System.out.println("Seulement " + nbTestOk
                    + " sont corrects sur un total de "
                    + donneeCorrecte.length);
        }

        // on vérifie que les chaînes incorrectes sont bien évaluées à incorrect
        nbTestOk = 0;
        for (int i = 0; i < donneeIncorrecte.length; i++) {
            if (donneeIncorrecte[i].matches(regex)) {
                System.out.println("ERREUR : La chaîne " + donneeIncorrecte[i]
                        + " a été évaluée comme correcte.");
            } else {
                nbTestOk++;
            }
        }

        // on affiche un résumé des tests
        System.out.print("Résumé des tests avec chaînes incorrectes => ");
        if (nbTestOk == donneeIncorrecte.length) {
            System.out.println("Tous tests sont OK");
        } else {
            System.out.println("Seulement " + nbTestOk
                    + " sont corrects sur un total de "
                    + donneeIncorrecte.length  );
        }
    }


    /**
     * Programme principal permettant de lancer les tests
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
        testRegex("Vérification regex  colonne contenant le nom", REGEX_COLONNE_NOM,
                CHAINE_CORRECTE_COLONNE_NOM, CHAINE_INCORRECTE_COLONNE_NOM);
        System.out.println();
        testRegex("Vérification regex  colonne contenant la note", REGEX_COLONNE_NOTE,
                CHAINE_CORRECTE_COLONNE_NOTE, CHAINE_INCORRECTE_COLONNE_NOTE);

    }

}