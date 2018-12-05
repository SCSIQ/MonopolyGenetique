package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce1 extends Terrain {
    public BleuFonce1(int position) {
        super(position);
        super.setPrix(3500);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=350;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=2000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1750;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=5000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=11000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=13000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=15000;
    }

    @Override
    public String toString() {
        return "Avenue des Champs-Elysées";
    }
}
