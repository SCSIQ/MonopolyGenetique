package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel3 extends Terrain {

    public BleuCiel3(int position) {
        super(position);
        super.setPrix(1200);
    }

    @Override
    public String toString() {
        return "Avenue de la République";
    }
}
