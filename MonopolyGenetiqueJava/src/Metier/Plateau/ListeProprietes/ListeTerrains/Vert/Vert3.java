package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert3 extends Terrain {
    public Vert3(int position) {
        super(position);
        super.setPrix(3200);

        setLoyerSansMaison(280);
        setPrixAjoutMaison(2000);
         setLoyer1Maison(1500);
         setLoyer2Maison(4500);
         setLoyer3Maison(1000);
         setLoyer4Maison(1200);
         setLoyerHotel(1400);

    }

    @Override
    public String toString() {
        return "Boul. des Capucines";
    }
}
