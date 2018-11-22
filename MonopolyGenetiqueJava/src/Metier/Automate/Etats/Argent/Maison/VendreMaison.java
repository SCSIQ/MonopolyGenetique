package Metier.Automate.Etats.Argent.Maison;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;

public class VendreMaison extends Etat {
    public VendreMaison(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

    }

    @Override
    public Etat transition(String event) {
        return null;
    }
}
