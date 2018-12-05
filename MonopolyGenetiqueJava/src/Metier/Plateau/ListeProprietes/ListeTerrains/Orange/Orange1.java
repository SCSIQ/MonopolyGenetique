package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange1 extends Terrain {

    public Orange1(int position) {
        super(position);
        super.setPrix(1800);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=140;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=700;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=2000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=5500;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=7500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=9500;
    }

    @Override
    public String toString() {
        return "Avenue Mozart";
    }
}
