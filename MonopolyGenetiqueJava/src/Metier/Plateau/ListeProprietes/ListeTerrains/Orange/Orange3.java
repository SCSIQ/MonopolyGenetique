package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange3 extends Terrain {

    public Orange3(int position) {
        super(position);
        super.setPrix(2200);
    }

    @Override
    public String toString() {
        return "Place Pigale";
    }
}
