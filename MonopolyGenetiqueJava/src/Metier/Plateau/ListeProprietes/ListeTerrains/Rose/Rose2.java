package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose2 extends Terrain {

    public Rose2() {
        super(13);
        super.setPrix(1400);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Avenue de Neuilly";
    }
}
