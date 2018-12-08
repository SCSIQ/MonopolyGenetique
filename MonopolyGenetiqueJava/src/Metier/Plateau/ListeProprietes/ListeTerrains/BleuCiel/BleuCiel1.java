package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel1 extends Terrain {

    public BleuCiel1(int position) {
        super(position);
        super.setPrix(1000);

        setLoyerSansMaison(60);
        setPrixAjoutMaison(500);
        setLoyer1Maison(300);
        setLoyer2Maison(900);
        setLoyer3Maison(2700);
        setLoyer4Maison(4000);
        setLoyerHotel(5500);

        super.couleur=CouleurMétier.BleuCiel;
            }

    @Override
    public String toString() {
        return "Rue de Vaugirard";
    }
}
