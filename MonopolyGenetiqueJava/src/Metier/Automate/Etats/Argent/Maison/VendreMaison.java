package Metier.Automate.Etats.Argent.Maison;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

import java.util.ArrayList;

public class VendreMaison extends Etat {

    private int prixVenteMaison;

    public VendreMaison(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }



    @Override
    public void agir(String event) {
        Joueur joueurCourant = super.getAutomate().getJoueurCourant();
        Cases caseCourante = super.getAutomate().getJoueurCourant().getPion().getCase();
        int prixMaison = ((Terrain) caseCourante).getPrixAjoutMaison() ;

        if (caseCourante instanceof Terrain) {

            //si le propriétaire de la propriété est le joueur courant
            if (((Terrain) caseCourante).getProprio() == joueurCourant) {

                //si il est possible de vendre une maison
                if (((Terrain) caseCourante).getNbMaisons() >0 ) {
                    joueurCourant.IncrementerSolde(prixMaison);
                    ((Terrain) caseCourante).supprimerMaison();
                    System.out.println("    Maison vendu : " + caseCourante.toString() + " au prix de " + ((Terrain) caseCourante).getPrixAjoutMaison() + "€");
                    System.out.println("    Argent restant pour le joueur : " + joueurCourant.getSolde() + "€");

                }
            }
        }
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() { return "VendreMaison{}"; }
}
