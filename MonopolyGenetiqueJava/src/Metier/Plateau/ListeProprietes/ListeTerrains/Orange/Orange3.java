package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange3 extends Terrain {

    public Orange3(int position) {
        super(position);
        super.setPrix(2000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=160;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=800;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=2200;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=6000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=8000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=10000;
    }

    @Override
    public String toString() {
        return "Place Pigale";
    }
}
