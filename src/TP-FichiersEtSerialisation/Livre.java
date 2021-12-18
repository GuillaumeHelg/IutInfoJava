/**
 * Classe qui repr?sente un livre
 * Livre.java                                                  11/20
 */
package TP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Classe repr?sentant un livre avec titre du livre, nom de son auteur,
 * et ann?e de parution
 * @author INFO2
 * @version 1.0
 */
public class Livre implements Serializable {


    private static final long serialVersionIUD = 1L;

    
    /**
     * Constante pour la valeur par d?faut des chaa?nes de caract?res
     */
    private static final String CHAINE_DEFAUT = "Information inconnue";
    
    /**
     * Constante pour la valeur par d?faut de l'ann?e de parution
     */
    private static final int PARUTION_DEFAUT = 9999;

    
    /** Titre du livre */
    private String titre;
    
    /** Auteur du livre */
    private String auteur; 
    
    /** Ann?e de parution du livre */
    private int parution; 

    
    /**
     * Constructeur par d?faut
     */
    public Livre() {
        titre = auteur = CHAINE_DEFAUT;
        parution = PARUTION_DEFAUT;
    }

    /**
     * Constructeur avec argument pour initialiser les 3 attributs. Si un
     * argument est invalide, c'est la valeur par d?faut qui est utilis?e
     * @param leTitre       le titre du livre
     * @param lAuteur       l'auteur du livre
     * @param anneeParution l'ann?e de parution du livre
     */
    public Livre(String leTitre, String lAuteur, int anneeParution) {
        titre = (leTitre == null || leTitre.length() == 0 ? CHAINE_DEFAUT
                                                          : leTitre);
        auteur = (lAuteur == null || lAuteur.length() == 0 ? CHAINE_DEFAUT
                                                           : lAuteur);
        parution = (anneeParution <= 0 ? PARUTION_DEFAUT : anneeParution);
    }

    /**
     * Accesseur sur le tirre
     * @return une cha?ne contenant le titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Accesseur sur l'auteur du livre
     * @return une cha?ne contenant l'auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Accesseur sur l'ann?e de parution
     * @return un entier contenant l'ann?e de parution
     */
    public int getParution() {
        return parution;
    }

    /**
     * Modifie le titre du livre courant avec l'argument.
     * Si le nouveau titre est invalide, c'est le titre par d?faut qui est
     * attribu?
     * @param nouveauTitre   nouveau titre pour le livre
     */
    public void setTitre(String nouveauTitre) {
        titre = (nouveauTitre == null || nouveauTitre.length() == 0 ? CHAINE_DEFAUT
                : nouveauTitre);
    }
    
    /**
     * Modifie l'auteur du livre courant avec l'argument.
     * Si le nouvel auteur est invalide, c'est l'auteur par d?faut qui est
     * attribu?
     * @param nouvelAuteur   nouvel auteur pour le livre
     */
    public void setAuteur(String nouvelAuteur) {
        auteur = (nouvelAuteur == null || nouvelAuteur.length() == 0 ? CHAINE_DEFAUT
                : nouvelAuteur);
    }
    
    /**
     * Modifie l'ann?e de parution du livre courant avec l'argument.
     * Si la nouvelle ann?e de parution est invalide, 
     * c'est l'ann?e par d?faut qui est attribu?e
     * @param nouvelleParution  nouvelle ann?e de parution du livre
     */
    public void setParution(int nouvelleParution) {
        parution = (nouvelleParution <= 0 ? PARUTION_DEFAUT : nouvelleParution);        
    }
    
    /**
     * Renvoie la description compl?te du livre
     * @return une cha?ne contenant le titre, l'auteur et l'ann?e de parution
     */
    public String toString() {
        return titre + " - " + auteur + "  (paru en" + parution + ")";
    }
    
  
    
    /**
     * Recopie les attributs du livre argument dans l'instance courante
     * @param aRecopier  livre ? recopier dans l'instance courante
     */
    private void recopier(Livre aRecopier) {
        this.setTitre(aRecopier.getTitre());
        this.setAuteur(aRecopier.getAuteur());
        this.setParution(aRecopier.getParution());
    }
    
   

}
