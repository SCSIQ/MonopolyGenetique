package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge3 extends Terrain {
    public Rouge3(int position) {
        super(position);
        super.setPrix(24000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=2000;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=15000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=10000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=30000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=75000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=92500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=110000;
    }

    @Override
    public String toString() {
        return "Avenue Henri-Martin";
    }
}
