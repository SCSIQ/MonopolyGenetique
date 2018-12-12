package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Cartes.CartesChances.Chance;
import java.util.Random;

import java.util.ArrayList;

public class PiocherCarte extends Etat {
    public PiocherCarte(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Random rand = new Random();

        if(getAutomate().getJoueurCourant().getPion().getCase() instanceof Metier.Plateau.ListeCartes.Chance)
        {
            getAutomate().getListeDesCartes().get(rand.nextInt(/*2*/1)).agir(getAutomate());
        }
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "PiocherCarte{}";
    }
}
