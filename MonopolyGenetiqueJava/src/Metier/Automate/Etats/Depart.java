package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class Depart extends Etat {
    public Depart(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {


        /*si le joueur courant s'arrête sur la case départ précissement il gagne 3 000€*/
      /* if( getAutomate().getJoueurCourant().getPion().getCase().toString()=="Depart"){
            getAutomate().getJoueurCourant() +=3000 ;
        }else {
           getAutomate().getJoueurCourant() +1500;
        }*/
    }

    @Override
    public Etat transition(String event) {
        return null;
    }
}
