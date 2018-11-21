package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public abstract class Etat {

    private ArrayList<Joueur> listeJoueurs;
    private Automate automate;

    public Etat(Automate automate, ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
        this.automate = automate;
    }

    //cette méthode permet de demander à l'Etat de faire ce pour quoi il existe,
    //elle est appellée uniquement par l'automate
    public abstract void agir(String event);

    //cette méthode permet de demander la transition dans l'Etat suivant
    //elle est appellée uniquement par l'automate
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
