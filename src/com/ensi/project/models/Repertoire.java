package com.ensi.project.models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import com.ensi.project.models.Fichier;

public class Repertoire {

    private String nom;
    private Fichier [] fichiers;
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

    private void checkFileLength()throws Exception{
        if (current_index>=maxFiles)throw new Exception("YOU CAN'T ADD NO MORE BRO");
    }

    public void ajouterUnFichier(){
        while (true){
            try {
                ajouterFichier();
            } catch  (Exception e) {
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
            Fichier file = new Fichier(fileName,extension,taille);
            //pour affecter le nouveau fichier au tab
            fichiers[current_index++]=file;
            // ask if the user wants to continue
            in.nextLine();
            do {
                System.out.print("Continuez (o/n)...");
                ok = in.nextLine();
            } while (!ok.equals("n") && !ok.equals("o"));
            if(ok.equals("n"))
                throw new Exception("Fin de saisie");



    }


    @Override
    public String toString() {
        return "Repertoire{" +
                "nom='" + nom + '\'' +
                ", fichiers=" + Arrays.toString(fichiers) +
                ", maxFiles=" + maxFiles +
                ", current_index=" + current_index +
                '}';
    }

    public void show() {
        System.out.println(this.toString());
    }

    public void menuSelectSection(){

        System.out.println("~ Menu ~");
        System.out.println("1-Afficher tout les fichiers ");
        System.out.println("2-Ajouter un fichier");
        System.out.println("3-Rechercher les fichiers ayant l'extension pdf ");

    }


    public void rechercherPDF() {
        for (int i = 1; i < current_index; i++) {
            if (Objects.equals(fichiers[i].getExtension(), "pdf")){
                System.out.println(fichiers[i]);
            }
        }
    }
}
