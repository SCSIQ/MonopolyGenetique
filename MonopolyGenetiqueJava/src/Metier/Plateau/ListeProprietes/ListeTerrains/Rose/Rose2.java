package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose2 extends Terrain {

    public Rose2(int position) {
        super(position);
        super.setPrix(1400);
    }

    @Override
    public String toString() {
        return "Avenue de Neuilly";
    }
}
