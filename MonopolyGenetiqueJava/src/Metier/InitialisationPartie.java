package Metier;

import Entites.CouleurPion;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Plateau.Cases;
import Metier.Plateau.Depart;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.Robinet;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel1;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel2;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose3;
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
        this.listeCases.add(new Marron1());
        //this.listeCases.add(null);
        this.listeCases.add(new Marron2());
        //this.listeCases.add(null);
        //this.listeCases.add(null);
        this.listeCases.add(new BleuCiel1());
        //this.listeCases.add(null);
        this.listeCases.add(new BleuCiel2());
        this.listeCases.add(new BleuCiel3());
        this.listeCases.add(new Prison());
        this.listeCases.add(new Rose1());
        this.listeCases.add(new Robinet());
        this.listeCases.add(new Rose2());
        this.listeCases.add(new Rose3());
        this.listeCases.add(new ParcGratuit());
    }

    private void creationListeJoueurs(int nombre, ArrayList<CouleurPion> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.add(new Joueur(this.listeCases, listeCouleurs.get(i)));
        }
    }
}
