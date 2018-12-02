package Metier.Automate.Etats.Argent.Maison;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class AcheterMaison extends Etat {

    public AcheterMaison(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Joueur joueurCourant = super.getAutomate().getJoueurCourant();
        Cases caseCourante = super.getAutomate().getJoueurCourant().getPion().getCase();


        //tout d'abord, lors de la création d'une case coté métier, indiquer le prix d'achat d'une maison
        //(bien penser à l'ajouter dans la classe propriete)

        //ensuite,
        //récupérer le pris d'une maison sur la case puis demande au joueur de donner son solde
        //ensuite l'état soustrait du solde du joueur le prix puis redonne le nouveau solde au joueur

        //enfin, dire à la case qu'elle a une maison de plus ( ajouterMaison() )

        //pour finir tu peux faire l'Etat vendreMaison{}

        // si la caseCourante est une instance de Terrain
        if (caseCourante instanceof Terrain) {

            //si le terrain n'a pas de maison
            if (((Terrain) caseCourante).getNbMaisons() == 0) {

                //si le solde du joueur courant est suppérieur ou égal
                if (joueurCourant.getSolde() >= ((Terrain) caseCourante).getPrixAjoutMaison()){


                    System.out.println("    Maison achetée : "+caseCourante.toString()+" au prix de "+ ((Terrain) caseCourante).getPrixAjoutMaison()+"€");
                    System.out.println("    Argent restant pour le joueur : "+joueurCourant.getSolde()+"€");
                }else{
                System.out.println("    La maison ne peut pas être acheté car le joueur n'a pas assez d'argent...");  }
            }
        }
    }

    /////TRANSITION///////
    @Override
    public Etat transition(String event) { return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs()); }

    public String toString() { return "AcheterMaison{}";    }

}
