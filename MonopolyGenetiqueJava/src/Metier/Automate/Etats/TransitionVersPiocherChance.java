package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class TransitionVersPiocherChance extends Etat {

    public TransitionVersPiocherChance(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

    }

    @Override
    public Etat transition(String event) {
        return new PiocherCarteChance(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "TransitionVersPiocherChance{}";
    }
}
