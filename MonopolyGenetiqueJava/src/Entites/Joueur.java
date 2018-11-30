package Entites;

import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Joueur {

    private String nom; // nom du joueur
    private Color couleur; //couleur du joueur
    private int solde ; // montant de l'argent possédé
    private Pion pion ;
    private boolean aLanceDes = false; // initialise le boolean pour savoir si le joueur a déjà lancer les dés
    private ArrayList<Proprietes> listePropietes;
    private int resDes1 = 0; // initialise à 0 le dés 1
    private int resDes2 = 0; // initialise à 0 le dés 2
    private int resLanceDes = 0; // initialise à 0 l'addition des deux dés
    private int nbDoubles = 0; //nombre de doubles que fait le joueur lors du lancé des dés
    private ArrayList<Cases> listeCases;

    public Joueur(ArrayList<Cases> listeCases, Color couleur) {
        this.solde = 2000; //a revoir car valeur fausse
        this.listeCases = listeCases;
        this.pion = new Pion(this, listeCases.get(0), couleur);
    }

    public ArrayList<Proprietes> getListePropietes() {
        return listePropietes;
    } // renvoie la liste des propriétés que le joueur posséde

    public void setListePropietes(ArrayList<Proprietes> listePropietes) {
        this.listePropietes = listePropietes;
    } // modifie la liste des propriétés que le joueur posséde

    public boolean getaLanceDes() {
        return aLanceDes;
    } // fonction qui dit si le joueur a déjà lancer les dés avec vrai ou faux

    public void IncrementerSolde(int solde) {
        this.solde += solde;
    }//augmente le montant de l'argent que le joueur posséde

    public void DecrementerSolde(int solde) {
        this.solde -= solde;
    }//diminue le montant de l'argent que le joueur posséde
    

    public void setaLanceDes(boolean aLanceDes) {
        this.aLanceDes = aLanceDes;
    } // modifie la valeur du boolean

    public int getResDes1() {
        return resDes1;
    } //renvoie la valeur du premier dés

    public int getResDes2() {
        return resDes2;
    } //renvoie la valeur du deuxième dés

    public int getResLanceDes() {
        return resLanceDes;
    } // renvoie l'addition des deux dés

    public void setResDes1(int resDes1) {
        this.resDes1 = resDes1;
    } //modifie la valeur du premier dés

    public void setResDes2(int resDes2) {
        this.resDes2 = resDes2;
    } //modifie la valeur du deuxième dés

    public void setResLanceDes(int aresLanceDes) {
        this.resLanceDes = aresLanceDes;
    } // modifie le résultat de l'addition des deux dés

    public void avancer() {
        pion.avancer(this.resLanceDes);
    } // procédure qui fait avancer le pion sur le plateau

    public ArrayList<Cases> getListeCases() {
        return listeCases;
    }

    public Pion getPion() {
        return pion;
    } //retourne le pion

    @Override
    public String toString() {
        return "    position du joueur : "+this.pion.toString();
    }


    public String getNom() {
        return nom;
    } // renvoie le nom du joueur

    public void setNom(String nom) {
        this.nom = nom;
    } //modifie le nom du joueur

    public Color getCouleur() {
        return couleur;
    } //renvoie la couleur du joueur

    public int getSolde() {
        return solde;
    } // renvoie l'argent que le joueur posséde

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    } //modifie la valeur de la couleur

    public int getNbDoubles() {
        return nbDoubles;
    }

    public void setNbDoubles(int nbDoubles) {
        this.nbDoubles = nbDoubles;
    }
}

