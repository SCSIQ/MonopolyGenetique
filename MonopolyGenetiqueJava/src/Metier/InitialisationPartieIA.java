package Metier;

import Entites.CouleurPion;
import Entites.IA;
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

import java.util.ArrayList;

public class InitialisationPartieIA extends InitialisationPartie{

    private void creationListeIA(int nombre, ArrayList<CouleurPion> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            super.listeJoueurs.add(new IA(super.listeCases, listeCouleurs.get(i)));
        }
    }
}
