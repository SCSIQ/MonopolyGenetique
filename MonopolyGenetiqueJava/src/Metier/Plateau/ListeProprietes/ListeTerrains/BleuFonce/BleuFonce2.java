package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce2 extends Terrain {
    public BleuFonce2(int position) {
        super(position);
        super.setPrix(4000);
    }

    @Override
    public String toString() {
        return "Rue de la Paix";
    }
}
