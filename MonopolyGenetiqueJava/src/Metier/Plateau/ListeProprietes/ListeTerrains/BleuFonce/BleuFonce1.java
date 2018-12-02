package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce1 extends Terrain {
    public BleuFonce1(int position) {
        super(position);
        super.setPrix(35000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=3500;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=20000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=17500;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=50000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=110000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=130000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=150000;
    }

    @Override
    public String toString() {
        return "Avenue des Champs-Elysées";
    }
}
