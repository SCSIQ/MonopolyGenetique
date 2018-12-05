package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel3 extends Terrain {

    public BleuCiel3(int position) {
        super(position);
        super.setPrix(1200);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=80;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=400;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=1000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=3000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=4500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=6000;
    }

    @Override
    public String toString() {
        return "Avenue de la République";
    }
}
