package Metier.Automate.Etats.Argent;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class PayerLoyer extends Etat {

    public PayerLoyer(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Joueur j = super.getListeJoueurs().get(0);
        int sommeAPayer = 0;

        if(j.getPion().getCase() instanceof Terrain)
        {
            System.out.println("    C'est un Terrain");
            System.out.println("    Nombre de maisons : "+((Terrain)j.getPion().getCase()).getNbMaisons());
            switch (((Terrain)j.getPion().getCase()).getNbMaisons()){
                case 0 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyerSansMaison();
                    System.out.println("    Loyer sans maison : "+((Terrain)j.getPion().getCase()).getLoyerSansMaison());
                    break;
                case 1 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyer1Maison();
                    break;
                case 2 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyer2Maison();
                    break;
                case 3 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyer3Maison();
                    break;
                case 4 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyer4Maison();
                    break;
                case 5 :
                    sommeAPayer = ((Terrain)j.getPion().getCase()).getLoyerHotel();
                    break;
                //default : sommeAPayer = 0;
            }
            j.DecrementerSolde(sommeAPayer);
            ((Proprietes) j.getPion().getCase()).getProprio().IncrementerSolde(sommeAPayer);
        }
        else if(j.getPion().getCase() instanceof Gare)
        {
            System.out.println("    C'est une gare");
            sommeAPayer = ((Gare)j.getPion().getCase()).getLoyer();
            j.DecrementerSolde(sommeAPayer);
            ((Proprietes) j.getPion().getCase()).getProprio().IncrementerSolde(sommeAPayer);
        }
        else if(j.getPion().getCase() instanceof ServicePublic)
        {
            System.out.println("    C'est un Service Public");
            /*sommeAPayer = ((ServicePublic)j.getPion().getCase()).getLoyer();
            j.DecrementerSolde(sommeAPayer);
            ((Proprietes) j.getPion().getCase()).getProprio().IncrementerSolde(sommeAPayer);*/
        }
        System.out.println("    Somme à payer : "+sommeAPayer);
        System.out.println("    Le joueur a maintenant "+j.getSolde()+"€");
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "PayerLoyer{}";
    }
}
