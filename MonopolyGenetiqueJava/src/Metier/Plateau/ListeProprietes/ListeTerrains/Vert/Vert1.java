package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert1 extends Terrain {
    public Vert1(int position) {
        super(position);
        super.setPrix(3000);
    }

    @Override
    public String toString() {
        return "Avenue de Breteuil";
    }
}
