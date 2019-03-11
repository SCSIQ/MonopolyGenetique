package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class FinPartie extends Etat {

    private Automate automate;

    public FinPartie(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        this.automate=automate;
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        automate.setPartieFinie(true);

        System.out.println(automate.getJoueurCourant().getNom()+" a gagné.");
        automate.evoluer(null);
    }

    @Override
    public Etat transition(String event) {
        return new FinPartie(getAutomate(), getListeJoueurs());
    }

    public String toString() {
        return "FinPartie";
    }
}
