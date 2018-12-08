package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune2 extends Terrain {
    public Jaune2(int position) {
        super(position);
        super.setPrix(2600);

        setLoyerSansMaison(220);
        setPrixAjoutMaison(1500);
         setLoyer1Maison(1100);
         setLoyer2Maison(3300);
         setLoyer3Maison(8000);
         setLoyer4Maison(9750);
         setLoyerHotel(11500);

        super.couleur= CouleurMétier.Jaune;
    }

    @Override
    public String toString() {
        return "Place de la Bourse";
    }
}
