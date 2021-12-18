package LaClassePersonne.test;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AffichageTrain {




    public static void ecrire(String nomFichier, String[] tab) {


        PrintStream sortie;
        sortie = null;

        try {
            sortie = new PrintStream(nomFichier);
            for(String aEcrire : tab)  {
                sortie.println(aEcrire);
            }
            System.out.println("Dates ecrites dans " + nomFichier);
        } catch (FileNotFoundException e) {
            System.out.println("Fichier " + nomFichier + " Pas accessible");
            e.printStackTrace();
        } finally {
            if(sortie != null) {
                sortie.close();
            }
        }
    }

    public static void recopier(String nomFichier, String nomCible) {

    StringBuilder copie = new StringBuilder();
    String ligne;

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(nomCible));
            do {
                ligne = fichier.readLine();
                if (ligne != null) {
                    copie.append(ligne +"\n");
                    System.out.println(" -- " + ligne);
                }

            } while(ligne != null);
            fichier.close();

        } catch (IOException e) {
            System.out.println("Pb d'acces fichier");
        }


        PrintStream sortie;
        sortie = null;

        try {
            sortie = new PrintStream(nomFichier);
            sortie.println(copie);

            System.out.println("Dates ecrites dans " + nomFichier);
        } catch (FileNotFoundException e) {
            System.out.println("Fichier " + nomFichier + " Pas accessible");
            e.printStackTrace();
        } finally {
            if(sortie != null) {
                sortie.close();
            }
        }


    }

    public static void lire(String nomFichier) {

        String ligne;

        try {

            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));
            do {
                ligne = fichier.readLine();
                if (ligne != null) {
                    System.out.println(" -- " + ligne);
                }

            } while(ligne != null);
            fichier.close();

        } catch (IOException e) {
            System.out.println("Pb d'acces fichier");
        }


    }

    public static void VerifOrdre(String nomFichier1, String nomFichier2) {

        String ligne1;
        String ligne2;

        try {

            BufferedReader fichier1 = new BufferedReader(new FileReader(nomFichier1));
            BufferedReader fichier2 = new BufferedReader(new FileReader(nomFichier2));


            do {
                ligne1 = fichier1.readLine();
                ligne2 = fichier2.readLine();


                if (ligne1 != null && ligne2 != null) {
                    System.out.println(" -- " + ligne1);
                    System.out.println(" -- " + ligne2);
                    if(ligne1.compareTo(ligne2) == 0) {
                        System.out.println("Lignes egale");
                    }

                }

            } while(ligne1 != null);
            fichier1.close();
            fichier2.close();

        } catch (IOException e) {
            System.out.println("Pb d'acces fichier");
        }

    }
    public static void main(String[] args) {

        String nomFichier;
        String cible;
        String[] tab = {"Bill Gates", "Dujardin Hector", "Dupont Nestor", "Dutilleul Parfait", "Hugo Victor", "Martin Martin", "Zola Emile"};

        Scanner entree = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier que vous souhaitez : ");
        nomFichier = entree.next();
        entree.nextLine();

        System.out.println("Entrez le nom du fichier que vous souhaitez : ");
        cible = entree.nextLine();


        //ecrire(nomFichier+".txt", tab);

        //lire(nomFichier+".txt");

        //recopier(nomFichier+".txt", cible+".txt");






    }
}