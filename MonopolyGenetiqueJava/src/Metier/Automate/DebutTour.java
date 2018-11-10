package Metier.Automate;

import Entites.Joueur;
import Metier.Automate.Choix.ChoixPossibles;

import java.util.ArrayList;

public class DebutTour extends Etat{

    public DebutTour(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        Joueur j = super.getListeJoueurs().get(0);
        j.setaLanceDes(false); //just in case
        j.setResLanceDes(0);
        //ici ajouter les actions automatisées que doivent faire les joueurs en début de tour si il y en a
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "DebutTour{}";
    }
}
