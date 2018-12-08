package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron1 extends Terrain {

    public Marron1(int position) {
        super(position);
        super.setPrix(600);
        setLoyerSansMaison(20);
        setPrixAjoutMaison(500);
         setLoyer1Maison(100);
         setLoyer2Maison(300);
         setLoyer3Maison(900);
         setLoyer4Maison(1600);
         setLoyerHotel(2500);

        super.couleur= CouleurMétier.Marron;
    }

    @Override
    public String toString() {
        return "Boul. de Belleville";
    }
}
