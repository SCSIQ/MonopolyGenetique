package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune1 extends Terrain {
    public Jaune1(int position) {
        super(position);
        super.setPrix(2600);
    }

    @Override
    public String toString() {
        return "Faubourg Saint-Honoré";
    }
}
