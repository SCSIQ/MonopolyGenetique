package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert2 extends Terrain {
    public Vert2(int position) {
        super(position);
        super.setPrix(3000);
        setLoyerSansMaison(260);
        setPrixAjoutMaison(2000);
         setLoyer1Maison(1300);
         setLoyer2Maison(3900);
         setLoyer3Maison(9000);
         setLoyer4Maison(1100);
         setLoyerHotel(12750);

    }

    @Override
    public String toString() {
        return "Avenue Foch";
    }
}
