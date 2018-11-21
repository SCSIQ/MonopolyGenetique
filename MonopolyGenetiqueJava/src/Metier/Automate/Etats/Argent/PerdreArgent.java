package Metier.Automate.Etats.Argent;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;

public class PerdreArgent extends Etat {

    public PerdreArgent(Automate automate, ArrayList<Joueur> listeJoueurs) {
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
