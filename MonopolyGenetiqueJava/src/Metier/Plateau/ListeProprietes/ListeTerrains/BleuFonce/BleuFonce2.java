package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce2 extends Terrain {
    public BleuFonce2(int position) {
        super(position);
        super.setPrix(4000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=500;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=2000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=2000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=6000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=14000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=17000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=20000;
    }


    @Override
    public String toString() {
        return "Rue de la Paix";
    }
}
