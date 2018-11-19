package Metier;

import Entites.CouleurPion;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Plateau.Cases;
import Metier.Plateau.Depart;
import Metier.Plateau.ListeCartes.CaisseCommune1;
import Metier.Plateau.ListeCartes.Chance1;
import Metier.Plateau.ListeProprietes.ListeGares.Gare1;
import Metier.Plateau.ListeProprietes.ListeGares.Gare2;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.Robinet;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel1;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel2;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose3;
import Metier.Plateau.ListeTaxes.Impot;
import Metier.Plateau.ParcGratuit;
import Metier.Plateau.Prison;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class InitialisationPartie {

    protected ArrayList<Cases> listeCases = new ArrayList<>();
    protected ArrayList<Joueur> listeJoueurs = new ArrayList<>();

    public Automate automateInitialisation(int nombreJoueurs, ArrayList<Color> listeCouleurs){
        creationListeCases();
        creationListeJoueurs(nombreJoueurs, listeCouleurs);
        Automate automate = new Automate(this.listeJoueurs);
        return automate;
    }

    private void creationListeCases(){
        this.listeCases.add(new Depart()); //0
        this.listeCases.add(new Marron1()); //1
        this.listeCases.add(new CaisseCommune1()); //2
        this.listeCases.add(new Marron2()); //3
        this.listeCases.add(new Impot()); //4
        this.listeCases.add(new Gare1()); //5
        this.listeCases.add(new BleuCiel1()); //6
        this.listeCases.add(new Chance1()); //7
        this.listeCases.add(new BleuCiel2()); //8
        this.listeCases.add(new BleuCiel3()); //9
        this.listeCases.add(new Prison()); //10
        this.listeCases.add(new Rose1()); //11
        this.listeCases.add(new Robinet()); //12
        this.listeCases.add(new Rose2()); //13
        this.listeCases.add(new Rose3()); //14
        this.listeCases.add(new Gare2()); //15
        //...
        this.listeCases.add(new ParcGratuit()); //20
    }

    private void creationListeJoueurs(int nombre, ArrayList<Color> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.add(new Joueur(this.listeCases, listeCouleurs.get(i)));
        }
    }
}
