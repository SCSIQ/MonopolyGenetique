package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose3 extends Terrain {

    public Rose3(int position) {
        super(position);
        super.setPrix(1600);

        setLoyerSansMaison(120);
        setPrixAjoutMaison(1000);
         setLoyer1Maison(600);
         setLoyer2Maison(1800);
         setLoyer3Maison(5000);
         setLoyer4Maison(7000);
         setLoyerHotel(9000);

        super.couleur= CouleurMétier.Rose;
    }

    @Override
    public String toString() {
        return "Rue du Paradis";
    }
}
