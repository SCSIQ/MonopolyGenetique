package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune3 extends Terrain {
    public Jaune3(int position) {
        super(position);
        super.setPrix(2800);
    }

    @Override
    public String toString() {
        return "Rue Lafayette";
    }
}
