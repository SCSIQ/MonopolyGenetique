package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;

import java.util.ArrayList;

public class Depart extends Etat {
    public Depart(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

        //si le joueur courant s'arrête sur la case départ précissement il gagne 3 000€
        if( super.getAutomate().getJoueurCourant().getPion().getCase().toString()=="Depart"){
            super.getAutomate().getJoueurCourant().IncrementerSolde(3000);
        }else { // sinon il gagne 1 500€
            super.getAutomate().getJoueurCourant().IncrementerSolde(1500);
        }
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Depart{}";
    }
}
