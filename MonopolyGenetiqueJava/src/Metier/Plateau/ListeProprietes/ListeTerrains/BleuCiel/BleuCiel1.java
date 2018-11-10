package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel1 extends Terrain {

    public BleuCiel1() {
        super(6);
        super.setPrix(1000);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Rue de Vaugirard";
    }
}
