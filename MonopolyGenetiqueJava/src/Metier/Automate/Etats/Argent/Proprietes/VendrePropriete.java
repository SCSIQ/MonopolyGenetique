package Metier.Automate.Etats.Argent.Proprietes;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class VendrePropriete extends Etat {



    public VendrePropriete(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        Joueur joueurCourant = super.getAutomate().getJoueurCourant();
        Cases caseCourante = joueurCourant.getListePropietes().get(getAutomate().getNumBouton()); //mis par défaut 0
        int prixCase = ((Proprietes) caseCourante).getPrix();

        // si la caseCourante est une instance de Propriété
        if(caseCourante instanceof Proprietes){

            //si le propriétaire de la propriété est le joueur courant
            if(((Proprietes) caseCourante).getProprio() == joueurCourant){
                ((Proprietes) caseCourante).setProprio(joueurCourant);
                joueurCourant.IncrementerSolde(prixCase);
                joueurCourant.getListePropietes().remove(getAutomate().getNumBouton());//mis par défaut 0
                System.out.println("    Propriété vendue: "+caseCourante.toString()+" au prix de "+prixCase+"€");
                System.out.println("    Argent restant pour le joueur : "+joueurCourant.getSolde()+"€");
                }
            }
        }


    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() { return "VendrePropriete{}";  }
}
