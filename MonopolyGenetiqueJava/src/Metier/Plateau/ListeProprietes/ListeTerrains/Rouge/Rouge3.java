package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge3 extends Terrain {
    public Rouge3(int position) {
        super(position);
        super.setPrix(2400);
        setLoyerSansMaison(200);
        setPrixAjoutMaison(1500);
         setLoyer1Maison(1000);
         setLoyer2Maison(3000);
         setLoyer3Maison(7500);
         setLoyer4Maison(9250);
         setLoyerHotel(11000);

    }

    @Override
    public String toString() {
        return "Avenue Henri-Martin";
    }
}
