package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron1 extends Terrain {

    public Marron1(int position) {
        super(position);
        super.setPrix(600);
    }

    @Override
    public String toString() {
        return "Boul. de Belleville";
    }
}
