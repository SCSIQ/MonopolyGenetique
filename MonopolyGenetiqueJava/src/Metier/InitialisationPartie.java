package Metier;

import Entites.CouleurPion;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Plateau.Cases;
import Metier.Plateau.Depart;
import Metier.Plateau.ParcGratuit;
import Metier.Plateau.Prison;

import java.util.ArrayList;

public class InitialisationPartie {

    private ArrayList<Cases> listeCases = new ArrayList<>();
    private ArrayList<Joueur> listeJoueurs = new ArrayList<>();

    public Automate automateInitialisation(int nombreJoueurs, ArrayList<CouleurPion> listeCouleurs){
        creationListeCases();
        creationListeJoueurs(nombreJoueurs, listeCouleurs);
        Automate automate = new Automate(this.listeJoueurs);
        return automate;
    }

    private void creationListeCases(){
        this.listeCases.add(new Depart());
        this.listeCases.add(new Prison());
        this.listeCases.add(new ParcGratuit());
    }

    private void creationListeJoueurs(int nombre, ArrayList<CouleurPion> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.add(new Joueur(this.listeCases.get(0), listeCouleurs.get(i)));
        }
    }
}
