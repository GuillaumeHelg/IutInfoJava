/*
 * TestDate.java                            23/04/2021
 * IUT Rodez, Aucun droit d'auteur
 */
package LaClassePersonne.test;

import Documents.ZutInfo.Personne;
import Documents.ZutInfo.Individu;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Test de classe Personne
 * @author Guillaume HELG
 */

public class TestPersonne {

    public static Personne P2 = new Personne("helg", "Guillaume", "07-96-85-85-85", "gui.helg@gmail.com");


    
    public static String[] MAIL_VALIDE = { "dvilejvoilvheovu.dcijiu@duhfeziu.com", "._-dkjv@iut-rodez.fr", "sdjvui@dsherui.com",
            "guillaume.helg@iut-rodez.fr", "guillaume.helg@gmail.com"
    };
    
    public static String[] MAIL_INVALIDE = { "sdjvui@dshe1&.com", "sdjvdsherui.com", "sdjvui@dsheruiom", "ijerruiverhui", "##cdjifvojvf@iut-rodez.fr",
            "guillaumehelgiut-rodez.com", "guillaume.com", "guillaume.helg@iut-rodezfr"};



    public static void testAfficher(){
        Personne P2 = new Personne("helg", "Guillaume", "07-96-85-85-85", "gui.helg@gmail.com");
        P2.afficher();
    }


    public static void testSaisir(){
        Personne P3 = new Personne();
        P3.saisir();
        P3.afficher();
    }

    public static void testInformation(){

        System.out.println(P2.Information());

    }

    public static void testMailValide(){


        for (String value : MAIL_VALIDE) {
            //System.out.println(P1.mailValide(MAIL_VALIDE[j]) + " " + j + 1);

            try {
                new Personne("test", "test", "0603236468", value);
                System.out.println("Test OK");
                /* Test OK */
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attrapée");
            }

        }


        for (String s : MAIL_INVALIDE) {
            //System.out.println(P2.mailValide(MAIL_INVALIDE[i]) +  " " + i+1);
            try {
                new Personne("test", "test", "0603236468", s);
                System.out.println("Test OK");
                /* Test OK */
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur de test attrapée !");
            }

        }
    }


    /**
     * Lancement des méthodes de tests
     * @param args non utilisé
     */
    public static void main(String[] args) {



        Scanner entree = new Scanner(System.in);
        int choix;

        Individu[] container = new Individu[5];

        for(int k = 0; k < container.length ; k++) {

            do {
                choix = 0;
                System.out.println("Veuillez saisir 1 ou 2 pour soit individu, soit personne");
                if (entree.hasNextInt()) {
                    choix = entree.nextInt();
                }

                entree.nextLine();

            }while(choix != 1 && choix != 2);

            if(choix == 1) {
                container[k] = new Individu();

            } else {
                container[k] = new Personne();
            }
            container[k].saisir();
            container[k].afficher();

            for (int l = 0; l < k; l++) {

                if(container[k].toString().equals(container[l].toString())) {
                    k--;
                    System.out.println("Prenom et nom deja exitant");
                }
            }
        }

        System.out.println(Arrays.toString(container));

        testAfficher();
        testSaisir();
        testInformation();
        testMailValide();




    }
}
