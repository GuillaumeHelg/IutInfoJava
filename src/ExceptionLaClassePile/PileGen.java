/*
 *
 * Pile.java                                                        17/09/21
 */

package ExceptionLaClassePile;

/**
 *
 * @author guillaume HELG
 * @version 1.0
 */
public class PileGen<T> {

    /**
     * Exception levée si la capacité entrée par l'utilisateur est invalide
     */
    public static class ErreurCapaciteInvalide extends Exception {

    }

    /**
     * Exception levée si lorsque la pile est vide l'utilisateur essaye de
     * dépiler un entier
     */
    public static class ErreurPileVide extends Exception {

    }

    /**
     * Exception levée si lorsque la pile est pleine l'utilisateur essaye de
     * piler un nouvelle entier
     */
    public static class ErreurPilePleine extends Exception {
        /* Corps vide pour le moment */
    }
    /** Capacité mmaximale de la pile par défaut */
    private static final int CAPACITE_MAX_DEFAUT = 10;

    /** Taille par défaut de la pile */
    private static final int TAILLE_DEFAUT = 0;

    /** Nombre maximum d'élément de la pile */
    private int capacite;

    /** Nombres d'entiers présents à un instant donné dans la pile */
    private int taille;

    /** Pour stocker les valeurs */
    private T[] element;

    /**  */

    /**
     * Initialise une pile vide
     */
    public PileGen() {
        this.capacite = CAPACITE_MAX_DEFAUT;
        this.taille = TAILLE_DEFAUT;
        element = (T[]) new Object[CAPACITE_MAX_DEFAUT];
    }

    /**
     * Initialise une pile avec les valeurs passées en arguments
     * @param capacite Nombre maximum d'élément de la pile
     * @throws IllegalArgumentException capacité négative
     */
    public PileGen(int capacite) throws ErreurCapaciteInvalide {

        if (capacite <= 0) {
            throw new ErreurCapaciteInvalide();
        }

        this.taille = TAILLE_DEFAUT;
        element = (T[]) new Object[capacite];
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
    public PileGen empiler(T newValeur) throws ErreurPilePleine {
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
    public T somment() throws ErreurPileVide {
        if (estVide()) {
            throw new ErreurPileVide();
        }
        return element[taille - 1];
    }

    /**
     * dépiler l'élément sommet de la pile */
    public PileGen depiler() throws ErreurPileVide {
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
    public static boolean memeCapacite(PileGen a, PileGen b) {
        return a.element.length == b.element.length;
    }

    /**
     * Compare la pile courante et la pile argument
     * @return un booléen égal à vrai ssi les 2 piles sont identiques :
     * même capacité et même contenu
     */
    @Override
    public boolean equals(Object aComparer) {
        boolean resultat = true; // on considère les piles égales
        // si aComparer n'est pas un objet de type pile
        if (! (aComparer instanceof PileGen)) {
            resultat = false;
        } else {
            // aComparer référence une Pile, on le convertit dans le type Pile
            PileGen pileGenAComparer = (PileGen) aComparer;
            // Comparaison des capacités et des tailles
            if (! memeCapacite(pileGenAComparer,this)
                    || pileGenAComparer.taille != this.taille) {
                resultat = false;
            } else {
            // on compare le contenu des piles
                int i; // indice de parcours
                for (i=0 ; i < taille
                        && pileGenAComparer.element[i] == this.element[i] ; i++);
                resultat = i == taille;
            }
        }
        return resultat;
    }
}





























