package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce1 extends Terrain {
    public BleuFonce1(int position) {
        super(position);
        super.setPrix(3500);
        setLoyerSansMaison(350);
        setPrixAjoutMaison(2000);
         setLoyer1Maison(1750);
         setLoyer2Maison(500);
         setLoyer3Maison(1100);
         setLoyer4Maison(1300);
         setLoyerHotel(1500);

    }



    @Override
    public String toString() {
        return "Avenue des Champs-Elysées";
    }
}
