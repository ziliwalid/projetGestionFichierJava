package com.ensi.project.models;

public class Fichier {
    private String nom;
    private String extension;
    private float taille;

    public Fichier() {
    }

    public Fichier(String nom, String extension, float taille) {
        this.nom = nom;
        this.extension = extension;
        this.taille = taille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }


    @Override
    public String toString() {
        return "Fichier{" +
                "nom='" + nom + '\'' +
                ", extension='" + extension + '\'' +
                ", taille=" + taille +"KO"+
                '}';
    }


}
