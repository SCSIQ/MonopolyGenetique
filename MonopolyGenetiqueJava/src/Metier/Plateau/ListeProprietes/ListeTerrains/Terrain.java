package Metier.Plateau.ListeProprietes.ListeTerrains;

import IHM.Plateau.Couleur;
import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class Terrain extends Proprietes {

    private Couleur couleur ;
    private int maison ;

    public Terrain(int position) {
        super(position);
    }

    public void AcheterMaison() {

    }

    public void VendreMaison(){

    }
}
