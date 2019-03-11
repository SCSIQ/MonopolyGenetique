package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class FinPartie extends Etat {

    private Automate automate;

    public FinPartie(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        this.automate=automate;
    }

    @Override
    public void agir(String event) {
        System.out.println(automate.getJoueurCourant()+" a gagné.");
    }

    @Override
    public Etat transition(String event) {
        return null;
    }

    public String toString() {
        return "FinPartie";
    }
}
