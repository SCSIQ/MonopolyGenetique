package Metier.Automate.Etats.Argent;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.ChoixPossibles;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;

public class Faillite extends Etat {

    public Faillite(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        Joueur joueurCourant = super.getAutomate().getJoueurCourant();
        ////supprime le joueur courant
        getListeJoueurs().remove(0);
        getAutomate().getListeJoueurs().remove(joueurCourant);
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Faillite{}";
    }
}
