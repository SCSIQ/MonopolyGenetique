package Metier.Automate.Etats.Choix;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Argent.Proprietes.AcheterPropriete;
import Metier.Automate.Etats.Des.LancerDesJoueur;
import Metier.Automate.Etats.Etat;
import Metier.Automate.Etats.FinTour;

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
        else if(event == "tourSuivant" && getListeJoueurs().get(0).getaLanceDes()==true){
            return new FinTour(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event == "acheterPropriete"){
            return new AcheterPropriete(super.getAutomate(), super.getListeJoueurs());
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
