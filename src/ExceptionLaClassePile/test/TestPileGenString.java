/*
 * TP CLASSE PILE - PROGRAMME DE TEST
 * ----------------------------------
 *
 *
 * tests de la classe Pile
 * TestPile.java                                                09/09/14
 */
package ExceptionLaClassePile.test;

import ExceptionLaClassePile.PileGenC;
import ExceptionLaClassePile.ErreurPile;

/**
 * Tests de base pour la classe Pile.
 * Les tests portent sur les différentes méthodes de la classe Pile,
 * ainsi que sur les exceptions susceptibles d'être levées par les
 * méthodes.
 * @author INFO2
 * @version 1.0
 */
public class TestPileGenString {

    /**
     * Vérifie que la pile argument est vide. Un message affiche le résultat
     * du test
     * @param p  pile supposée être vide
     * @param nomPile  nom de la pile testée
     */
    private static void testCreationPileVide(PileGenC<String> p, String nomPile){
        if (p.estVide()) {
            System.out.println("Création avec succès de la pile " + nomPile + " (vide) !"
                    + " Elle contient : " + p + "\n");
        } else {
            System.out.println("Test NOK pour la création "
                    + "de la pile " + nomPile + " !\n");
        }
    }

    /**
     * Test que les capacités des piles sont correctes
     * @param p             pile supposée avec la même capacité que identique
     * @param identique     pile supposée avec la même capacité que p
     * @param differente    pile avec une capactité différente des précédentes
     */
    private static void testCapacite(PileGenC<String> p, PileGenC<String> identique, PileGenC<String> differente) {

        if (PileGenC.memeCapacite(p, identique)
                && !PileGenC.memeCapacite(p, differente)
                && !PileGenC.memeCapacite(identique, differente)) {
            System.out.println("Test OK pour la méthode memeCapacite. \n");
        } else {
            System.out.println("Test NOK pour la méthode memeCapacite.\n");
        }
    }

    /**
     * Test de la méthode equals
     * @param p             pile supposée identique à identique
     * @param identique     pile supposée identique à  p
     * @param differente    pile supposée différente de p et identique
     */
    private static void testEgalite(PileGenC<String> p, PileGenC<String> identique, PileGenC<String> differente) {

        if (p.equals(identique) && !p.equals(differente)  && !p.equals(differente)) {
            System.out.println("Test OK pour la méthode equals. \n");
        } else {
            System.out.println("Test NOK pour la méthode equals.\n");
        }
    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, aucune exception
     * ne doit se produire. Cette assertion est également vérifiée par le test.
     */
    private static void testSansException() {

        // ETAPE 1 : Test des méthodes sans provoquer d'exception
        System.out.println("ETAPE de TEST numéro 1\n"
                + "    Test des méthodes de la classe Pile\n"
                + "    et vérification qu'aucune exception ne "
                + "se produit\n\n");

        /*
         * aucune exception ne doit se produire dans le code ci-dessous
         * sauf si l'utilisateur entre trop d'éléments pour la pile p
         */
        try {
            PileGenC<String> p = new PileGenC<>(5);                    // pile de référence
            PileGenC<String> inverse = new PileGenC<>(15);              // recevra l'inverse de p
            PileGenC<String> grandePile = new PileGenC<>(6);          // pour le test sur la capacité

            // on vérifie que les 3 piles sont vides,
            testCreationPileVide(p, "p");
            testCreationPileVide(inverse, "inverse");
            testCreationPileVide(grandePile, "grandePile");

            // on teste la méthode de comparaison des capacités, et equals
            testCapacite(p, inverse, grandePile);
            testEgalite(p, inverse, grandePile);

            // on empile les entiers de 1 à 5 dans la pile p
            for (int n = 1; n <= 5; n++) {
                p.empiler("" + n);
            }
            System.out.println("La pile p contient-elle les entiers de 1 à 5 ?\n"
                    + p + "       => "
                    + (p.toString().equals(
                    "[ sommet =  5 | 4 | 3 | 2 | 1 |  ]")
                    ? "OK " : "NOK") + "\n");

            // on dépile les éléments de p pour les empiler dans inverse
            while (!p.estVide()) {
                inverse.empiler(p.sommet());
                p.depiler();
            }
            System.out.println("Contenu de la pile inverse " + inverse + "    =>  "
                    + (inverse.toString().equals
                    ("[ sommet =  1 | 2 | 3 | 4 | 5 |  ]")
                    ? "OK " : "NOK") + "\n"
                    + "\net de la pile initiale (devenue vide) : "
                    + p + "   => " + (p.estVide() ? "OK" : "NOK") + "\n");

            // nouveau test pour equals
            System.out.println("Test " + (! inverse.equals(p) ? "ok " : "NOK")
                    + " pour equals");


            // autres tests pour l'égalité
            inverse.depiler();
            inverse.depiler();      // inverse contient : sommet = 3, 4, 5
            p.empiler("salut");
            p.empiler("yop");
            System.out.println("Test " + (! inverse.equals(p) ? "ok " : "NOK")
                    + " pour equals");
            p.empiler("akha");
            System.out.println("Test " + (inverse.equals(p) ? "ok " : "NOK")
                    + " pour equals");

        } catch (ErreurPile.ErreurCapaciteInvalide e) {
            System.out.println("Test NOK => Erreur inattendue : ErreurCapaciteInvalide");
        } catch (ErreurPile.ErreurPilePleine e) {
            System.out.println("Test NOK => Erreur inattendue : ErreurPilePleine");
        } catch (ErreurPile.ErreurPileVide e) {
            System.out.println("Test NOK => Erreur inattendue : ErreurPileVide");
        }

    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, on vérifie que les
     * exceptions attendues sont bien propagées.
     */
    private static void testDesExceptions() {

        int testOk = 0;                     // nombre de tests corrects
        // ETAPE 2 : Test des exceptions
        System.out.println("\n\nETAPE de TEST numéro 2\n"
                + "    Vérification que les exceptions sont levées\n");

        // l'exception ErreurCapaciteInvalde sera levée  (constructeur)
        try {
            PileGenC<String> p = new PileGenC<>(-5);
            System.out.println("Test NOK pour capacité invalide");
        } catch (ErreurPile.ErreurCapaciteInvalide err) {
            testOk++;
            System.out.println("Exception ErreurCapaciteInvalide correctement gérée.");
        }

        // l'exception ErreurPilePleine sera levée (méthode empiler)
        try {
            PileGenC<String> p = new PileGenC<>(5);
            for (int i = 1; i <= 6 ; i++) {
                p.empiler("arf");
            }
            System.out.println("Test NOK pour empiler (ErreurPilePleine)");
        } catch (ErreurPile.ErreurCapaciteInvalide err) {
            System.out.println("Test NOK pour capacité invalide");
        } catch (ErreurPile.ErreurPilePleine err) {
            testOk++;
            System.out.println("Exception ErreurPilePleine correctement gérée.");
        }

        // l'exception ErreurPileVide sera levée (méthode depiler)
        try {
            PileGenC<String> p = new PileGenC<>(5);
            p.depiler();
            System.out.println("Test NOK pour depiler (ErreurPileVide)");
        } catch (ErreurPile.ErreurCapaciteInvalide err) {
            System.out.println("Test NOK pour capacité invalide");
        } catch (ErreurPile.ErreurPileVide err) {
            testOk++;
            System.out.println("Exception ErreurPileVide correctement gérée.");
        }

        // l'exception ErreurPileVide sera levée (méthode sommet)
        try {
            PileGenC<String> p = new PileGenC<>(5);
            System.out.println(p.sommet());
            System.out.println("Test NOK pour sommet (ErreurPileVide)");
        } catch (ErreurPile.ErreurCapaciteInvalide err) {
            System.out.println("Test NOK pour capacité invalide");
        } catch (ErreurPile.ErreurPileVide err) {
            testOk++;
            System.out.println("Exception ErreurPileVide correctement gérée.");
        }

        // résultat global du test
        if (testOk == 4) {
            System.out.println("Tous les tests sur les exceptions ont réussi.");
        } else {
            System.out.println("Au moins un test sur les exceptions a échoué.");
        }
    }


    /**
     * Fonction principale
     * @param args paramètre non utilisé
     */
    public static void main(String[] args) {

        // test des méthodes sans lever les exceptions
        testSansException();

        // test de la propagation correcte des exceptions
        testDesExceptions();
    }
}