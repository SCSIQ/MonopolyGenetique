package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose3 extends Terrain {

    public Rose3(int position) {
        super(position);
        super.setPrix(1600);
    }

    @Override
    public String toString() {
        return "Rue du Paradis";
    }
}
