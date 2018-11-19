package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron2 extends Terrain {

    public Marron2(int position) {
        super(position);
        super.setPrix(800);
    }

    @Override
    public String toString() {
        return "Rue Lecourbe";
    }
}
