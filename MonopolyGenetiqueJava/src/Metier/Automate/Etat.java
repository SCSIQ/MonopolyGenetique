package Metier.Automate;

import Entites.Joueur;

import java.util.ArrayList;

public abstract class Etat {

    private ArrayList<Joueur> listeJoueurs;
    private Automate automate;

    public Etat(Automate automate, ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
        this.automate = automate;
    }

    public abstract void agir(String event);
    public abstract Etat transition(String event);

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public Automate getAutomate() {
        return automate;
    }
}
