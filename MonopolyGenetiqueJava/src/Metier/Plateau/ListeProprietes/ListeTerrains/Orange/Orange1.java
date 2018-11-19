package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange1 extends Terrain {

    public Orange1(int position) {
        super(position);
        super.setPrix(1800);
    }

    @Override
    public String toString() {
        return "Avenue Mozart";
    }
}
