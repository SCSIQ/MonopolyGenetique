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
        /* si le joueur courant a fait un tour et qu'il passe par la case départ il gagne 1 500€ */
       /* if( getAutomate().getJoueurCourant() || getAutomate().getJoueurCourant() ){
            getAutomate().getJoueurCourant().setSolde() +=1500 ;
        }
        si le joueur courant s'arrête sur la case départ précissement il gagne 3 000€
        if( getAutomate().getJoueurCourant().getListeCases()=="Depart"){
            getAutomate().getJoueurCourant().setSolde() +=3000 ;
        }*/
    }

    @Override
    public Etat transition(String event) {
        return null;
    }
}
