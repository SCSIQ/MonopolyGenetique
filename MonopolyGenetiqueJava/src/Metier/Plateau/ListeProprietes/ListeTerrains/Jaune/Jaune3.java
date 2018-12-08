package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune3 extends Terrain {
    public Jaune3(int position) {
        super(position);
        super.setPrix(2800);
        setLoyerSansMaison(240);
        setPrixAjoutMaison(1500);
         setLoyer1Maison(1200);
         setLoyer2Maison(3600);
         setLoyer3Maison(8500);
         setLoyer4Maison(1025);
         setLoyerHotel(12000);

        super.couleur= CouleurMétier.Jaune;
    }

    @Override
    public String toString() {
        return "Rue Lafayette";
    }
}
