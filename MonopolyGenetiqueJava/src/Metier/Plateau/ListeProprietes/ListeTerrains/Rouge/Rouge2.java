package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge2 extends Terrain {
    public Rouge2(int position) {
        super(position);
        super.setPrix(2200);
    }

    @Override
    public String toString() {
        return "Boul. Malesherbes";
    }
}
