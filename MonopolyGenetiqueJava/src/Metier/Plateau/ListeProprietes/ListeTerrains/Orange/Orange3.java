package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange3 extends Terrain {

    public Orange3(int position) {
        super(position);
        super.setPrix(2000);

        setLoyerSansMaison(160);
        setPrixAjoutMaison(1000);
         setLoyer1Maison(800);
         setLoyer2Maison(2200);
         setLoyer3Maison(6000);
         setLoyer4Maison(8000);
         setLoyerHotel(1000);

    }

    @Override
    public String toString() {
        return "Place Pigale";
    }
}
