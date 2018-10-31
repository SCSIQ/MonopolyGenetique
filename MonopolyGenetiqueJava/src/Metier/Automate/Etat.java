package Metier.Automate;

import Entites.Joueur;

public abstract class Etat {

    private Joueur joueur;

    public Etat(Joueur joueur){
        this.joueur = joueur;
    }

    public abstract void agir();
    public abstract Etat transition();
}
