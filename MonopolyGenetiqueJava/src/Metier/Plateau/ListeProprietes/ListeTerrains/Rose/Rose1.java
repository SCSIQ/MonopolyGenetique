package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose1 extends Terrain {

    public Rose1(int position) {
        super(position);
        super.setPrix(1400);
    }

    @Override
    public String toString() {
        return "Boul. de la Villette";
    }
}
