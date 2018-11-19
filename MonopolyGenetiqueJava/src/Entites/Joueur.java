package Entites;

import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Joueur {

    private String nom;
    private Color couleur;
    private int solde ;
    private Pion pion ;
    private boolean aLanceDes = false;
    private ArrayList<Proprietes> listePropietes;
    private int resDes1 = 0;
    private int resDes2 = 0;
    private int resLanceDes = 0;
    private ArrayList<Cases> listeCases;

    public Joueur(ArrayList<Cases> listeCases, CouleurPion couleur) {
        this.solde = 500; //a revoir car valeur fausse
        this.listeCases = listeCases;
        this.pion = new Pion(this, listeCases.get(0), couleur);
    }

    public ArrayList<Proprietes> getListePropietes() {
        return listePropietes;
    }

    public void setListePropietes(ArrayList<Proprietes> listePropietes) {
        this.listePropietes = listePropietes;
    }

    public boolean getaLanceDes() {
        return aLanceDes;
    }

    public void setaLanceDes(boolean aLanceDes) {
        this.aLanceDes = aLanceDes;
    }

    public int getResDes1() {
        return resDes1;
    }

    public int getResDes2() {
        return resDes2;
    }

    public int getResLanceDes() {
        return resLanceDes;
    }

    public void setResDes1(int resDes1) {
        this.resDes1 = resDes1;
    }

    public void setResDes2(int resDes2) {
        this.resDes2 = resDes2;
    }

    public void setResLanceDes(int aresLanceDes) {
        this.resLanceDes = aresLanceDes;
    }

    public void avancer() {
        pion.avancer(this.resLanceDes);
    }

    public ArrayList<Cases> getListeCases() {
        return listeCases;
    }

    public Pion getPion() {
        return pion;
    }

    @Override
    public String toString() {
        return "    position du joueur : "+this.pion.toString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public int getSolde() {
        return solde;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

}
