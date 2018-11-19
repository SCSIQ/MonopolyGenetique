package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce1 extends Terrain {
    public BleuFonce1(int position) {
        super(position);
        super.setPrix(3500);
    }

    @Override
    public String toString() {
        return "Avenue des Champs-Elysées";
    }
}
