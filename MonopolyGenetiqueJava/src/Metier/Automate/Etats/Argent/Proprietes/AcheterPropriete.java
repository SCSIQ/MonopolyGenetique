package Metier.Automate.Etats.Argent.Proprietes;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class AcheterPropriete extends Etat{

    public AcheterPropriete(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Joueur joueurCourant = super.getAutomate().getJoueurCourant();
        Cases caseCourante = super.getAutomate().getJoueurCourant().getPion().getCase();

        if(caseCourante instanceof Proprietes && joueurCourant.getSolde() >= ((Proprietes) caseCourante).getPrix()){
            ((Proprietes) caseCourante).setProprio(joueurCourant);
            joueurCourant.DecrementerSolde(((Proprietes) caseCourante).getPrix());
            joueurCourant.ajouterPropriete((Proprietes) caseCourante);
        }
        else{
            System.out.println("    La propriété ne peut pas être acheté car le joueur n'a pas assez d'argent...");
        }

    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "AcheterPropriete{}";
    }
}
