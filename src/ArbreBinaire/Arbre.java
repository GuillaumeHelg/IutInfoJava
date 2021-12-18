package ArbreBinaire;

public class Arbre<T extends Comparable<T>> {

    private static final int DECALAGE = 5;
    private Noeud<T> racine;

    /**
     * Constructeur Arbre dans lequel l'on va initialiser la valeur de noeud
     */
    public Arbre() {
        racine = null;
    }

    /**
     *
     * @param valeur
     * @return
     */
    public boolean estValeurPresente1(T valeur) {
        if(racine == null) {
            return false;
        }
        return racine.estValeurPresente(valeur);
    }

    /**
     *
     * @param valeurAInserer
     * @return
     */
    public boolean insertionValeur1(T valeurAInserer) {
        if(racine == null) {
            racine = new Noeud<>(valeurAInserer);
            return true;
        }
        return racine.insererValeur(valeurAInserer);
    }

    /**
     *
     */
    public void afficheOrdreCroissant() {
        if(racine == null) {
            System.out.println("vide");
        }
        racine.afficherValeurOrdreCroissant();
    }

    /**
     *
     */
    public void afficherArbreHierarchie() {
        if (racine == null) {

        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Arbre<Integer> a1 = new Arbre<>();
        a1.afficherArbreHierarchie();
    }


}
