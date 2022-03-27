package com.ensi.project.models;

import java.util.Objects;
import java.util.Scanner;

public class Repertoire {

    private String nom;
    private Fichier[] fichiers;
    final int maxFiles = 30;
    private int current_index;

    Scanner in = new Scanner(System.in);


    public Repertoire() {
    }

    public Repertoire(String nom) {
        this.nom = nom;
        this.current_index = 1;
        this.fichiers = new Fichier[maxFiles];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Fichier[] getFichiers() {
        return fichiers;
    }

    public void setFichiers(Fichier[] fichiers) {
        this.fichiers = fichiers;
    }
    //Méthodes:

    private void checkFileLength() throws Exception {
        if (current_index >= maxFiles) throw new Exception("YOU CAN'T ADD NO MORE BRO");
    }

    public void ajouterUnFichier() {
        while (true) {
            try {
                ajouterFichier();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public void ajouterFichier() throws Exception {
        checkFileLength();
        String ok = "";
        System.out.println("Veuillez saisir le nom du fichier: ");
        String fileName = in.nextLine();
        System.out.println("Veuillez saisir l'extension du fichier: ");
        String extension = in.nextLine();
        System.out.println("Veuillez saisir la taille du fichier: ");
        float taille = in.nextFloat();
        Fichier file = new Fichier(fileName, extension, taille);
        //pour affecter le nouveau fichier au tab
        fichiers[current_index++] = file;
        // ask if the user wants to continue
        in.nextLine();
        do {
            System.out.print("Continuez (o/n)...");
            ok = in.nextLine();
        } while (!ok.equals("n") && !ok.equals("o"));
        if (ok.equals("n"))
            throw new Exception("Fin de saisie");


    }


    /*@Override
    public String toString() {
        return "Repertoire{" +
                "nom='" + nom + '\'' +
                ", fichiers=" + Arrays.toString(fichiers) +
                ", maxFiles=" + maxFiles +
                ", current_index=" + current_index +
                '}';
    }
*/
    public void show() {
        boolean isEmptyList = true;
        for (int i = 0; i < maxFiles; i++) {
            if (fichiers[i] != null) {
                isEmptyList = false;
                System.out.println(fichiers[i]);
            }

        }
        if (isEmptyList) System.out.println("Liste vide");
    }

    public void menuSelectSection() {

        System.out.println("~ Menu ~");
        System.out.println("1-Afficher tout les fichiers ");
        System.out.println("2-Ajouter un fichier");
        System.out.println("3-Rechercher les fichiers ayant l'extension pdf ");
        System.out.println("4-Rechercher un fichier ");
        System.out.println("5-Modifier la taille d'un fichier ");
        System.out.println("6-Supprimer un fichier ");
        System.out.println("7-Trier les fichiers selon la taille  ");
        System.out.print("**Saisissez votre choix:   ");

    }

    public void rechercherFichier() {
        System.out.print("veuillez saisir le nom du fichier: ");
        String resName = in.nextLine();
        for (int i = 1; i < current_index; i++) {
            if (fichiers[i].getNom().equals(resName)) {
                System.out.println(fichiers[i]);
            } else {
                System.out.println("Pas de fichier portant ce nom");
            }
        }
    }

    public void modifierTaille() {
        System.out.println("Saisissez le nom du fichier pour modifier sa taille ");
        String resName = in.nextLine();
        System.out.println("Saisissez la taille: ");
        float editedSize = in.nextFloat();
        for (int i = 1; i < current_index; i++) {
            if (Objects.equals(fichiers[i].getNom(), resName)) {
                fichiers[i].setTaille(editedSize);
                System.out.println(fichiers[i]);
            }
        }
    }

    public void rechercherPDF() {
        for (int i = 1; i < current_index; i++) {
            if (Objects.equals(fichiers[i].getExtension(), "pdf")) {
                System.out.println(fichiers[i]);
            } else {
                System.out.println("no pdf files");
                break;
            }
        }
    }

    public void supprimerFichier() {
        System.out.println("Saisissez le nom du fichier a supprimer");
        String delName = in.nextLine();
        Fichier[] newArray = new Fichier[maxFiles];
        for (int i = 0, k = 0; i < maxFiles; i++) {
            if (fichiers[i] != null) {
                if (Objects.equals(fichiers[i].getNom(), delName)) {
                    current_index--;
                } else {
                    newArray[k++] = fichiers[i];
                }
            }
        }
        fichiers = new Fichier[maxFiles];
        for (int i = 0; i < maxFiles; i++) {
            fichiers[i] = newArray[i];
        }

        show();

    }
    static void bubbleSort(Fichier[] fichiers) {
        int n = fichiers.length;
        Fichier temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (compare(fichiers, j - 1, j)) {
                    //swap elements
                    temp = fichiers[j - 1];
                    fichiers[j - 1] = fichiers[j];
                    fichiers[j] = temp;
                }
            }
        }
    }
    public void sortArray () {
        bubbleSort(fichiers);
    }

    private static boolean compare(Fichier[] fichiers, int a, int b) {
        Fichier fichierA = fichiers[a];
        Fichier fichierB = fichiers[b];
        if (fichierB == null) return true;
        if (fichierA == null) return false; //Here fichierB is already not null
        return fichierA.getTaille() > fichierB.getTaille();
    }
}
