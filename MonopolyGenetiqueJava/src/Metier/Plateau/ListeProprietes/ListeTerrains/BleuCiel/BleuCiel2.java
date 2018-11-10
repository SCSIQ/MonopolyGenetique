package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel2 extends Terrain {

    public BleuCiel2() {
        super(8);
        super.setPrix(1000);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Rue de Courcelles";
    }
}
