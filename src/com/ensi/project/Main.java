package com.ensi.project;

import com.ensi.project.models.Repertoire;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

         Repertoire repertoire = new Repertoire("sa");
         Scanner in = new Scanner(System.in);




         int choice= -1;
        do {
            repertoire.menuSelectSection();
            choice = in.nextInt();
            switch (choice){
                case 1 :repertoire.show()                ; break;
                case 2 :repertoire.ajouterUnFichier()    ; break;
                case 3 :repertoire.rechercherPDF()       ; break;
                case 4 :repertoire.rechercherFichier()   ; break;
                case 5 :repertoire.modifierTaille();     ; break;
                case 6 :repertoire.supprimerFichier()    ; break;
                case 7 :repertoire.sortArray();          ; break;
                //case 5 :repertoire.modifierTaille();     ; break;
            }
        }while (choice!=0);
    }
}
