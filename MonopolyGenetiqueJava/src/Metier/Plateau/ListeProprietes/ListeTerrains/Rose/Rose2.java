package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose2 extends Terrain {

    public Rose2(int position) {
        super(position);
        super.setPrix(1400);

        setLoyerSansMaison(100);
        setPrixAjoutMaison(1000);
         setLoyer1Maison(500);
         setLoyer2Maison(1500);
         setLoyer3Maison(4500);
         setLoyer4Maison(6250);
         setLoyerHotel(7500);

        super.couleur= CouleurMétier.Rose;
    }

    @Override
    public String toString() {
        return "Avenue de Neuilly";
    }
}
