package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class FinTour extends Etat{

    public FinTour(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        ArrayList<Joueur> listeJoueurs = super.getListeJoueurs();
        Joueur j = listeJoueurs.get(0);
        listeJoueurs.remove(0);
        listeJoueurs.add(j);
        //super.setListeJoueurs(listeJoueurs);
    }

    @Override
    public Etat transition(String event) {
        return new DebutTour(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "FinTour{}";
    }
}
