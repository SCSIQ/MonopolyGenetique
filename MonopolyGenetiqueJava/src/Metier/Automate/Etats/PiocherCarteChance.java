package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.Random;

import java.util.ArrayList;

public class PiocherCarteChance extends Etat {
    public PiocherCarteChance(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        if(getAutomate().getJoueurCourant().getPion().getCase() instanceof Metier.Plateau.ListeCartes.Chance)
        {
            if(getAutomate().getTirerCarteChance()!=-1)
            {
                getAutomate().getListeDesCartesChances().get(getAutomate().getTirerCarteChance()).agir(getAutomate());
            }
            else
            {
                Random rand = new Random();
                getAutomate().getListeDesCartesChances().get(rand.nextInt(4)).agir(getAutomate());
            }
        }
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "PiocherCarteChance{}";
    }
}
