package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel1 extends Terrain {

    public BleuCiel1(int position) {
        super(position);
        super.setPrix(1000);
    }

    @Override
    public String toString() {
        return "Rue de Vaugirard";
    }
}
