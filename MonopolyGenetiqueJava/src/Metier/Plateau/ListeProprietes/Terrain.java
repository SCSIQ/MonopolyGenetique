package Metier.Plateau.ListeProprietes;

import IHM.Plateau.Couleur;

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
