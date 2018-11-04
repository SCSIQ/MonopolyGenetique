package Metier.Automate;

import Entites.Joueur;

import java.util.ArrayList;

public abstract class Etat {

    private ArrayList<Joueur> listeJoueurs;

    public Etat(ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
    }

    public abstract void agir();
    public abstract Etat transition();

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }
}