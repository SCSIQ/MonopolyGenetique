package Metier.Automate.Etats.Argent.Maison;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

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
        //Cases caseCourante = super.getAutomate().getJoueurCourant().getPion().getCase();
        Cases caseCourante = getAutomate().getCasePourAjoutMaison();
        int prixMaison = ((Terrain) caseCourante).getPrixAjoutMaison() ;

        // si la caseCourante est une instance de Terrain
        if (caseCourante instanceof Terrain) {

            //si le propriétaire de la propriété est le joueur courant
            if (((Terrain) caseCourante).getProprio() == joueurCourant) {

                //si il est possible de construire sur le terrain
                if (((Terrain) caseCourante).getNbMaisons() < 5) {

                    //if(((Terrain)caseCourante).getProprioPossedeTouteLaCouleur()==true){
                        //si le solde du joueur courant est suppérieur ou égal
                        if (joueurCourant.getSolde() >= prixMaison) {
                            joueurCourant.DecrementerSolde(prixMaison);
                            ((Terrain) caseCourante).ajouterMaison();
                            System.out.println("    Maison achetée : " + caseCourante.toString() + " au prix de " + ((Terrain) caseCourante).getPrixAjoutMaison() + "€");
                            System.out.println("    Le terrain possède maintenant "+((Terrain) caseCourante).getNbMaisons()+" maisons");
                            System.out.println("    Argent restant pour le joueur : " + joueurCourant.getSolde() + "€");
                        } else {
                            System.out.println("    La maison ne peut pas être acheté car le joueur n'a pas assez d'argent...");
                        }
                    //}
                }
            }else{
                System.out.println( " La maison ne peut pas être acheté car vous n'êtes pas le propriétaire de cette propriété");
            }
        }
    }
    /////TRANSITION///////
    @Override
    public Etat transition(String event) { return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs()); }

    public String toString() { return "AcheterMaison{}";    }

}
