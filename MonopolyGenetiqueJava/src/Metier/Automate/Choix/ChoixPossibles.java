package Metier.Automate.Choix;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Des.LancerDesJoueur;
import Metier.Automate.Etat;
import Metier.Automate.FinTour;

import java.util.ArrayList;

public class ChoixPossibles extends Etat {

    public ChoixPossibles(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {
        //cet état n'a pas pour vocation de faire quelque chose de particulier mais plutôt
        //de permettre la transition entre plusieurs actions possibles parmi le choix proposé
        //au joueur comme par exemple lancer les dés, consulter ses propriétés, etc
    }

    @Override
    public Etat transition(String event) {
        if(event == "lancerDes"){
            return new LancerDesJoueur(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event == "tourSuivant"){
            return new FinTour(super.getAutomate(), super.getListeJoueurs());
        }
        else{
            return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
    }

    @Override
    public String toString() {
        return "ChoixPossibles{}";
    }
}
