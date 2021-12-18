package ExceptionLaClassePile;

import Documents.ZutInfo.ErreurPile;

/**
 * Cette classe représente une pile d'entiers.
 * Les opérations possibles sont
 * création de la pile,
 * tester si la pile est vide ou pleine,
 * empiler une valeur,
 * dépiler,
 * consulter la valeur du sommet,
 * renvoyer le contenu de la pile sous-la forme d'une chaîne de caractères,
 * déterminer si 2 piles ont la même capacité,
 * déterminer si 2 piles sont égales
 * @author INFO2
 * @version 1.0
 */

public class PileGenC<T> {


    /**
     * Valeur par défaut pour la capacité de la pile
     */
    private static final int CAPACITE_DEFAUT = 10;

    /**
     * Taille de la pile (ou nombre d'éléments qu'elle contient)
     * Le sommet de la pile se trouve donc à l'indice taille-1
     */
    private int taille;
    /**
     * Tableau contenant les entiers éléments de la pile
     */
    private T[] element;

    /**
     * Constructeur par défaut (pile vide avec la capacité par défaut)
     */
    public PileGenC() {
        // création d'une pile vide ayant la capacité par défaut
        taille = 0; // à sa création, la pile est vide
        element = (T[]) new Object[CAPACITE_DEFAUT];
    }

    /**
     * Construit une pile vide avec la capacité argument
     *
     * @param capacite capacité de la pile à créer
     * @throws ErreurPile.ErreurCapaciteInvalide levée si la capacité est invalide
     */
    public PileGenC(int capacite) throws ErreurPile.ErreurCapaciteInvalide {
// si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new ErreurPile.ErreurCapaciteInvalide("Ici c'est moi qui fait la loi");
        }
// sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element = (T[]) new Object[capacite];
    }

    /**
     * Détermine si la pile est pleine
     *
     * @return un booléen égal à vrai ssi la pile est pleine
     */
    public boolean estPleine() {
        return taille == element.length;
    }

    /**
     * Détermine si la pile est vide
     *
     * @return un booléen égal à vrai ssi la pile est vide
     */
    public boolean estVide() {
        return taille == 0;
    }

    /**
     * Empile un entier
     *
     * @param valeur entier à empiler
     * @return la pile modifiée
     * @throws ErreurPile.ErreurPilePleine levée si la pile est pleine
     */
    public PileGenC empiler(T valeur) throws ErreurPile.ErreurPilePleine {
        // si la pile est pleine, on lève l'exception ErreurPilePleine
        if (estPleine()) {
            throw new ErreurPile.ErreurPilePleine("Doux jesus qu'a tu fais");
        }
        // sinon : on empile la valeur argument
        element[taille] = valeur;
        taille++;
        return this;
    }

    /**
     * Dépile le sommet de la pile
     *
     * @return la pile modifiée
     * @throws ErreurPile.ErreurPileVide levée si la pile est vide
     */
    public PileGenC depiler() throws ErreurPile.ErreurPileVide {
        // si la pile est vide, on lève l'exception ErreurPileVide
        if (estVide()) {
            throw new ErreurPile.ErreurPileVide("grosse erreur de ta part");
        }
        // sinon : on dépile
        taille--;
        return this;
    }


    /**
     * Renvoie la valeur du sommet de la pile
     *
     * @return le sommet de la pile (un entier)
     * @throws ErreurPile.ErreurPileVide levée si la pile est vide
     */
    public T sommet() throws ErreurPile.ErreurPileVide {
        // si la pile est vide, on lève l'exception ErreurPileVide
        if (estVide()) {
            throw new ErreurPile.ErreurPileVide("tu n'aurais pas du faire ça");
        }
        // sinon : on renvoie le sommet
        return element[taille - 1];
    }


    /**
     * Renvoie le contenu de la pile sous la forme d'une chaîne
     * dans le format [ sommet = liste des éléments de la pile]
     *
     * @return résultat une chaîne contenant les valeurs des éléments de la pile
     */
    @Override
    public String toString() {
// déclaration d'un objet de type StringBuilder (plus efficace que String)
        StringBuilder resultat = new StringBuilder("[ sommet = ");
        for (int i = taille - 1; i >= 0; i--) {
// append permet d'ajouter son argument à la fin de la chaîne résultat
            resultat.append(element[i]).append(" | ");
        }
        resultat.append(" ]");
        return resultat.toString();
    }

    /**
     * Détermine si 2 piles ont la même capacité
     *
     * @param a première pile
     * @param b deuxième pile
     * @return un booléen égal à vrai ssi les 2 piles arguments ont la même
     * capacité
     */
    public static boolean memeCapacite(PileGenC a, PileGenC b) {
        return a.element.length == b.element.length;
    }

    /**
     * Compare la pile courante et la pile argument
     *
     * @return un booléen égal à vrai ssi les 2 piles sont identiques :
     * même capacité et même contenu
     */
    @Override
    public boolean equals(Object aComparer) {
        boolean resultat = true; // on considère les piles égales
        // si aComparer n'est pas un objet de type pile
        if (!(aComparer instanceof Pile)) {
            resultat = false;
        } else {
            // aComparer référence une Pile, on le convertit dans le type Pile
            PileGenC pileAComparer = (PileGenC) aComparer;
            // Comparaison des capacités et des tailles
            if (!memeCapacite(pileAComparer, this)
                    || pileAComparer.taille != this.taille) {
                resultat = false;
            } else {
                // on compare le contenu des piles
                int i; // indice de parcours
                for (i = 0; i < taille
                        && pileAComparer.element[i] == this.element[i]; i++)
                    ;
                resultat = i == taille;
            }
        }
        return resultat;
    }
}