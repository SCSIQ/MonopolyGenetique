package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune2 extends Terrain {
    public Jaune2(int position) {
        super(position);
        super.setPrix(26000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=2200;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=15000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=11000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=33000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=80000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=97500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=115000;
    }

    @Override
    public String toString() {
        return "Place de la Bourse";
    }
}
