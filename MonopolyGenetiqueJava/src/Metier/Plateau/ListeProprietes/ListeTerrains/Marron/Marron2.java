package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron2 extends Terrain {

    public Marron2() {
        super(3);
        super.setPrix(800);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Rue Lecourbe";
    }
}
