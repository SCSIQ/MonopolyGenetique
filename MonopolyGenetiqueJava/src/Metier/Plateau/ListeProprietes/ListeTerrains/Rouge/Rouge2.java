package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge2 extends Terrain {
    public Rouge2(int position) {
        super(position);
        super.setPrix(2200);

        setLoyerSansMaison(180);
        setPrixAjoutMaison(1500);
         setLoyer1Maison(900);
         setLoyer2Maison(2500);
         setLoyer3Maison(7000);
         setLoyer4Maison(8750);
         setLoyerHotel(10500);

    }

    @Override
    public String toString() {
        return "Boul. Malesherbes";
    }
}
