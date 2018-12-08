package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce2 extends Terrain {
    public BleuFonce2(int position) {
        super(position);
        super.setPrix(4000);
        setLoyerSansMaison(250);
        setPrixAjoutMaison(2000);
         setLoyer1Maison(2000);
         setLoyer2Maison(6000);
         setLoyer3Maison(14000);
         setLoyer4Maison(17000);
         setLoyerHotel(20000);

        super.couleur= CouleurMétier.BleuFonce;
    }

    @Override
    public String toString() {
        return "Rue de la Paix";
    }
}
