package Metier.Automate;

import Entites.Joueur;
import Entites.Pion;
import Metier.Automate.Choix.ChoixPossibles;

import java.util.ArrayList;

public class Deplacement extends Etat{

    public Deplacement(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        //ici ajouter le code effectuant le déplacement
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
