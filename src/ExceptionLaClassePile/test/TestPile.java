/*
 *
 * Pile.java                                                        17/09/21
 */

package ExceptionLaClassePile.test;

import ExceptionLaClassePile.Pile;


/**
 * Classe qui représente un individu décrit par son nom et son prénom
 *
 * @author Guillaume HELG
 * @version 1.0
 */

public class TestPile {




    public static void main(String[] args) throws Pile.ErreurCapaciteInvalide {

       Pile pile = new Pile(5);


        if (pile.estVide()) {
            System.out.println(pile.estVide());


            System.out.println("La pile est vide !");
        } else {
            System.out.println(pile.estVide());

            System.out.println("La pile n'est pas vide !");
        }

        pile.empiler(6);
        pile.empiler(12);
        pile.empiler(18);

        if (pile.estVide()) {
            System.out.println("La pile est vide !");
            System.out.println(pile.estVide());

        } else {
            System.out.println("La pile n'est pas vide !");
            System.out.println(pile.estVide());

        }


        System.out.println("Valeur au sommet : " + pile.somment());
        System.out.println("Valeur de la Pile \n" + pile.toString());
        pile.depiler();
        System.out.println("Valeur de la Pile \n" + pile.toString());
        pile.empiler(19);
        pile.empiler(5);
        pile.empiler(61);

        if (pile.estPleine()) {
            System.out.println("La pile est pleine !");
        } else {
            System.out.println("La pile n'est pas pleine !");
        }

        /* Erreur provoqué */
        pile.empiler(45);

        /* Erreur provoqué */
        Pile pile2 = new Pile(-5);

        Pile p1 = new Pile(5);
        Pile p2 = new Pile(5);
        Pile p3 = new Pile(6);


        // pile avec capacité invalide
        Pile p4 = new Pile(-6);

        Pile p5 = new Pile(0);

        p5.depiler();


        System.out.println(p5.estVide());
        p5.somment();


        /* 5 */
        // test des méthodes sans lever les exceptions

        // test de la propagation correcte des exceptions







    }
}
