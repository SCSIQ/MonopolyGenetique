package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge1 extends Terrain {

    public Rouge1(int position) {
        super(position);
        super.setPrix(2200);
    }

    @Override
    public String toString() {
        return "Avenue Matignon";
    }
}
