package Metier.Automate.Etats;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Argent.Maison.AcheterMaison;
import Metier.Automate.Etats.Argent.Proprietes.AcheterPropriete;
import Metier.Automate.Etats.Des.LancerDesJoueur;

import java.util.ArrayList;

public class ChoixPossibles extends Etat {

    public ChoixPossibles(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

        if(getAutomate().getJoueurCourant() instanceof IA){
            System.out.println("C'est une IA !!!");
        }

    }

    @Override
    public Etat transition(String event) {
        System.out.println("------------> event : "+event);
        if(event == "lancerDes"){
            return new LancerDesJoueur(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event == "tourSuivant" && getListeJoueurs().get(0).getaLanceDes()==true){
            return new FinTour(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event == "acheterPropriete"){
            return new AcheterPropriete(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event == "AcheterMaison"){
            return new AcheterMaison(super.getAutomate(), super.getListeJoueurs());
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
