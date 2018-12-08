package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron2 extends Terrain {

    public Marron2(int position) {
        super(position);
        super.setPrix(800);
        setLoyerSansMaison(40);
        setPrixAjoutMaison(500);
         setLoyer1Maison(200);
         setLoyer2Maison(600);
         setLoyer3Maison(1800);
         setLoyer4Maison(3200);
         setLoyerHotel(4500);

        super.couleur= CouleurMétier.Marron;
    }

    @Override
    public String toString() {
        return "Rue Lecourbe";
    }
}
