package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert3 extends Terrain {
    public Vert3(int position) {
        super(position);
        super.setPrix(3200);
    }

    @Override
    public String toString() {
        return "Boul. des Capucines";
    }
}
