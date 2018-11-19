package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune2 extends Terrain {
    public Jaune2(int position) {
        super(position);
        super.setPrix(2600);
    }

    @Override
    public String toString() {
        return "Place de la Bourse";
    }
}
