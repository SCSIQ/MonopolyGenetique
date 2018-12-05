package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel3 extends Terrain {

    public BleuCiel3(int position) {
        super(position);
        super.setPrix(1200);

        setLoyerSansMaison(80);
        setPrixAjoutMaison(500);
         setLoyer1Maison(400);
         setLoyer2Maison(1000);
         setLoyer3Maison(3000);
         setLoyer4Maison(4500);
         setLoyerHotel(6000);

    }

    @Override
    public String toString() {
        return "Avenue de la République";
    }
}
