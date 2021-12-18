/*
 *
 * Pile.java                                                        17/09/21
 */

package ExceptionLaClassePile;

/**
 * @author guillaume HELG
 * @version 1.0
 */
public class Pile {

    /**
     * Exception levée si la capacité entrée par l'utilisateur est invalide
     */
    @SuppressWarnings("serial")
    public static class ErreurCapaciteInvalide extends Exception {
    };

    /**
     * Exception levée si lorsque la pile est vide l'utilisateur essaye de
     * dépiler un entier
     */
    @SuppressWarnings("serial")
    public static class ErreurPileVide extends Exception {
    };

    /**
     * Exception levée si lorsque la pile est pleine l'utilisateur essaye de
     * piler un nouvelle entier
     */
    @SuppressWarnings("serial")
    public static class ErreurPilePleine extends Exception {
    };


    /** Capacité mmaximale de la pile par défaut */
    private static final int CAPACITE_MAX_DEFAUT = 10;

    /** Taille par défaut de la pile */
    private static final int TAILLE_DEFAUT = 0;

    /** Nombres d'entiers présents à un instant donné dans la pile */
    private int taille;

    /** Pour stocker les valeurs */
    private int[] element;

    /**  */

    /**
     * Initialise une pile vide
     */
    public Pile() {
        this.capacite = CAPACITE_MAX_DEFAUT;
        this.taille = 0;
        element = new int[CAPACITE_MAX_DEFAUT];
    }

    /**
     * Initialise une pile avec les valeurs passées en arguments
     * @param capacite Nombre maximum d'élément de la pile
     * @throws IllegalArgumentException capacité négative
     */
    public Pile(int capacite) throws ErreurCapaciteInvalide {

        if (capacite <= 0) {
            throw new ErreurCapaciteInvalide();
        }

        this.taille = TAILLE_DEFAUT;
        element = new int[capacite];
    }

    /**
     * Détermine si la pile est vide
     * @return true si vide
     *         false sinon
     */
    public boolean estVide() {
        return this.taille == 0;
    }

    public boolean estPleine() {
        return this.taille == element.length;
    }

    /**
     * empiler l'entier argument
     * @param newValeur nouvelle valeur à empiler
     */
    public Pile empiler(int newValeur) throws ErreurPilePleine {
        if (estPleine()) {
            throw new ErreurPilePleine();
        }
        element[taille] = newValeur;
        this.taille ++;

        return this;
    }

    /**
     * Renvoie la valeur du sommet de la pile
     * @return
     */
    public int somment() throws ErreurPileVide {
        if (estVide()) {
            throw new ErreurPileVide();
        }
        return element[taille - 1];
    }

    /**
     * dépiler l'élément sommet de la pile */
    public Pile depiler() throws ErreurPileVide {
        if (estVide()) {
            throw new ErreurPileVide();
        }

        this.taille --;

        return this;
    }

    /**
     * Renvoie un String avec le contenu de la pile
     * @return string
     */
    @Override
    public String toString() {

        StringBuilder chaine = new StringBuilder("[ sommet = ");

        for (int i = this.taille - 1; i >= 0; i--) {
            chaine.append(element[i] + " | ");
        }

        chaine.append(" ]");

        return chaine.toString();
    }

    /**
     * Opération qui détermine si deux piles ont la même capacité
     * @param  a que l'on comparer
     * @return true si égale
     *         false sinon
     */
    public static boolean memeCapacite(Pile a, Pile b) {
        return a.element.length == b.element.length;
    }

    public boolean equals(Object aComparer) {

        boolean resultat = true;

        if(!(aComparer instanceof Pile)) {
            resultat = false;
        } else {
            Pile pileAcomparer = (Pile) aComparer;

            if(! memeCapacite(pileAcomparer, this) || pileAcomparer.taille != this.taille) {
                resultat = false;
            } else {
                int i ;
                for(i = 0 ; i < taille && pileAcomparer.element[i] == this.element[i] ; i++);
                resultat = i == taille;
            }
        }

        return resultat;
    }
}





























