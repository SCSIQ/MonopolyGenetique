package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange2 extends Terrain {

    public Orange2(int position) {
        super(position);
        super.setPrix(1800);

        setLoyerSansMaison(140);
        setPrixAjoutMaison(1000);
         setLoyer1Maison(700);
         setLoyer2Maison(2000);
         setLoyer3Maison(5500);
         setLoyer4Maison(7500);
         setLoyerHotel(9500);

    }

    @Override
    public String toString() {
        return "Boul. Saint-Michel";
    }
}
