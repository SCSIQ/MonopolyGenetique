package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge3 extends Terrain {
    public Rouge3(int position) {
        super(position);
        super.setPrix(2400);
    }

    @Override
    public String toString() {
        return "Avenue Henri-Martin";
    }
}
