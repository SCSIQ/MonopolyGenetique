package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron1 extends Terrain {

    public Marron1() {
        super(1);
        super.setPrix(600);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Boul. de Belleville";
    }
}
