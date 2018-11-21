package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;

import java.util.ArrayList;

public class Deplacement extends Etat{

    public Deplacement(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        Joueur j = super.getListeJoueurs().get(0);
        System.out.println("    avant déplacement : "+j.toString());
        j.avancer(); //demande au joueur d'avancer son pion (le joueur connais les résultats de son lancé de dès)
        System.out.println("    après déplacement : "+j.toString());
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Deplacement{}";
    }
}
