package ArbreBinaire;

public class Noeud<T extends Comparable<T>> {

    //création des différentes variables qui correspondent a l'arbre
    private T valeur;
    private Noeud<T> gauche;
    private Noeud<T> droit;


    /**
     * Créer un object Noeud qui initialise les valeurs droit et gauche à NULL
     * La classe est prévu pour être générique
     * @param valeur : La valeur en paramètre permet d'initialiser la valeur courante
     */
    public Noeud(T valeur) {
        this.valeur = valeur;
        this.gauche = null;
        this.droit = null;
    }

    /**
     * Méthode qui regarde si la valeur en paramètre est déjà dans le noeud
     * @param valeur : valeur de type générique qui est recherché dans le noeud
     * @return : un boolean est retourné : vrai si la valeur est trouvée sinon faux
     */
    public boolean estValeurPresente(T valeur) {

        if(valeur.equals(this.valeur)) {
            return true;
        }
        if(valeur.compareTo(this.valeur) > 0) {
            if(droit != null) {
                return droit.estValeurPresente(valeur);
            } else {
                return false;
            }
        }
        if(valeur.compareTo(this.valeur) < 0) {
            if(gauche != null) {
                return gauche.estValeurPresente(valeur);
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Methode qui permet d'insérer une valeur passée en paramètre dans le noeud courant
     * @param valeur : Valeur générique qui va être intégrer dans le noeud courant
     * @return : on retourne un boolean vrai si la valeur est insérée sinon faux
     */
    public boolean insererValeur(T valeur) {

        if(estValeurPresente(valeur)) {
            return false;
        }

        if(valeur.compareTo(this.valeur) < 0) {
            if(this.gauche == null){
                this.gauche = new Noeud<T>(valeur);
                return true;
            } else {
                return gauche.insererValeur(valeur);

            }
        }

        if(valeur.compareTo(this.valeur) > 0) {
            if(this.droit == null){
                this.droit = new Noeud<T>(valeur);
                return true;
            } else {
                return droit.insererValeur(valeur);
            }
        }
        return false;
    }

    /**
     * Methode qui va afficher le contenu de l'objet arbre dans l'ordre préfixé
     * @return : on retourne la chaine qui contient l'affichage de l'arbre
     */
    public String affichageOrdrePrefixe() {
        String chaine = "";
        chaine = getValeurCourante()+"  ";

        if(gauche != null) {
            chaine += this.gauche.affichageOrdrePrefixe();
        }

        if(droit != null) {
            chaine += this.droit.affichageOrdrePrefixe();
        }

        if(this.valeur == null) {
            chaine = "Arbre vide";
        }
        return chaine;
    }



    /**
     * Méthode qui va afficher l'arbre dans l'ordre croissant
     */
    public void afficherValeurOrdreCroissant() {
        if(gauche != null) {
            gauche.afficherValeurOrdreCroissant();
        }

        System.out.println(this.getValeurCourante());

        if(droit != null) {
            droit.afficherValeurOrdreCroissant();
        }

    }

    /**
     * Methode qui va afficher le contenu de l'objet arbre dans l'ordre infixe
     * @return : on retourne la chaine qui contient l'affichage de l'arbre
     */
    public String afficheInfixe() {

        String chaine = "";

        if(gauche != null) {
            chaine += this.gauche.afficheInfixe()+"";
        }

        if(this.valeur != null) {
            chaine += this.getValeurCourante()+"  ";
        }

        if(droit != null) {

            chaine += this.droit.afficheInfixe()+"";
        }

        return chaine;
    }


    /**
     * Methode qui va afficher le contenu de l'objet arbre dans l'ordre postfixe
     * @return : on retourne la chaine qui contient l'affichage de l'arbre
     */
    public String affichePostfixe() {

        String chaine = "";

        if(gauche != null) {
            chaine += this.gauche.affichePostfixe()+" ";
        }

        if(droit != null) {
            chaine += this.droit.affichePostfixe()+" ";
        }

        chaine += getValeurCourante()+" ";

        return chaine;
    }

    /**
     * méthode qui va compter la hauteur de l'arbre binaire et retourner la valeur
     * @return la hauteur de l'arbre binaire
     */
    public int hauteurDeLArbre() {

        int compteur1 = 1;
        int compteur = 1;
        if(gauche != null) {
            compteur1 += this.gauche.hauteurDeLArbre();
        }

        if(droit != null) {
            compteur += this.droit.hauteurDeLArbre();
        }

        if(compteur < compteur1) {
            return compteur1;
        }

        return compteur;
    }

    /**
     * Methode qui va permettre de dire si une valeur est présente
     * sur une feuille
     * @param valeur : valeur recherchée par le programmeur
     * @return : retourne true si la valeur recherché est située sur une feuille sinon false
     */
    public boolean estPresenteSurUneFeuille(T valeur) {

        if(this.valeur.equals(valeur)) {
            return gauche == null && droit == null;
        }

        if(this.valeur.compareTo(valeur) > 0) {
            return this.gauche.estPresenteSurUneFeuille(valeur);
        }

        if(this.valeur.compareTo(valeur) < 0) {
            return this.droit.estPresenteSurUneFeuille(valeur);
        }

        return false;
    }

    /**
     * Methode qui retourne la plus grande valeur de l'arbre
     * Methode generique
     * @return : la valeur la plus grande de l'arbre
     */
    public T plusGrandeValeur() {
        return droit != null ? this.droit.plusGrandeValeur() : this.valeur;
    }


    /**
     * Recherche la valeur passé en argument dans l'arbre
     * Si elle est situé sur une feuille alors elle est supprimé
     * Sinon il ne se passe rien
     * @return : true si la valeur est supprimé, sinon false
     */
    public boolean supprimerValeurFeuille(T aSuppr) {

        if(aSuppr.compareTo(valeur) < 0) {

            if(gauche == null) {
                return false;
            }

            if(!gauche.valeur.equals(aSuppr)) {
                return gauche.supprimerValeurFeuille(aSuppr);
            }

            if(gauche.gauche == null && gauche.droit == null) {
                gauche = null;
                return true;
            }
            return false;
        } else if (aSuppr.compareTo(valeur) > 0) {
            if(droit == null) {
                return false;
            }

            if(!droit.valeur.equals(aSuppr)) {
                return droit.supprimerValeurFeuille(aSuppr);
            }

            if (droit.gauche == null && droit.droit == null) {
                droit = null;
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Noeud<T> plusGrandNoeud() {
        if(droit == null) {
            return this;
        }
        return droit.plusGrandNoeud();
    }

    /**
     * Methode qui va supprimer une valeur quelconque dans le programme
     * @return :
     */
    public boolean supprimer(Noeud<T> pere, T aSupprimer) {
        if(pere == null) {
            return false;
        }

        if(aSupprimer.compareTo(valeur) < 0) {
            return gauche != null && gauche.supprimer(this, aSupprimer);
        } else if(aSupprimer.compareTo(valeur) > 0) {
            return droit != null && droit.supprimer(this, aSupprimer);
        } else {
            if(droit == null) {
                if(pere.valeur.compareTo(aSupprimer) < 0) {
                    pere.droit = gauche;
                } else {
                    pere.gauche = droit;
                }
            } else if(gauche == null) {
                if (pere.valeur.compareTo(aSupprimer) < 0) {
                    pere.droit = droit;
                } else {
                    pere.gauche = droit;
                }
            } else {
                Noeud<T> aDeplacer = gauche.plusGrandNoeud();
                T plusGrandValeur = aDeplacer.valeur;

                gauche.supprimer(this, plusGrandValeur);

                this.valeur = plusGrandValeur;
            }
            return true;
        }
    }

    /**
     * getter qui permet de récupérer la valeur courant du noeud
     * @return : retourne une valeur générique qui correspond à la valeur courante du noeud
     */
    public T getValeurCourante() {
        return this.valeur;
    }

    /**
     * getter qui permet de récupérer la valeur gauche du noeud
     * @return : retourne une valeur générique qui correspond à la valeur gauche du noeud
     */
    public T getValeurSousArbreGauche() {
        return gauche.valeur;
    }

    /**
     * getter qui permet de récupérer la valeur droite du noeud
     * @return : retourne une valeur générique qui correspond à la valeur droite du noeud
     */
    public T getValeurSousArbreDroit() {
        return droit.valeur;
    }

    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    /**
     * Creation d'un nœud d'arbre binaire
     * et insertion de valeur
     *
     * Ce main permet de tester mes methodes
     * @param args : argument vide / pas utilisé
     */
    public static void main(String[] args) {
        Noeud<Integer> n1 = new Noeud<>(78);
        n1.insererValeur(96);
        n1.insererValeur(63);
        n1.insererValeur(103);
        n1.insererValeur(41);
        n1.insererValeur(12);
        n1.insererValeur(56);
        n1.insererValeur(45);
        n1.insererValeur(99);
        n1.insererValeur(26);
        System.out.println(n1.affichageOrdrePrefixe());
        System.out.println(n1.afficheInfixe());
        System.out.println(n1.affichePostfixe());
        System.out.println(n1.hauteurDeLArbre());
        System.out.println(n1.estPresenteSurUneFeuille(78));
        System.out.println(n1.plusGrandeValeur());
    }
}
