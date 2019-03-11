package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class StatsPartie extends Etat {

    public StatsPartie(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    public void Afficher(){

    }

    @Override
    public void agir(String event) {

    }

    @Override
    public Etat transition(String event) {
        return null;
    }

    public String toString() {
        return "Score Partie";
    }
}
