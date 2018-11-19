package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange2 extends Terrain {

    public Orange2(int position) {
        super(position);
        super.setPrix(1800);
    }

    @Override
    public String toString() {
        return "Boul. Saint-Michel";
    }
}
