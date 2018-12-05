package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge3 extends Terrain {
    public Rouge3(int position) {
        super(position);
        super.setPrix(2400);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=200;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=3000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=7500;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=9250;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=11000;
    }

    @Override
    public String toString() {
        return "Avenue Henri-Martin";
    }
}
