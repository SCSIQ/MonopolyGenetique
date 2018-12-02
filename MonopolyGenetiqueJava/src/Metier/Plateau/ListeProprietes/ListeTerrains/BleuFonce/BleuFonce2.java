package Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuFonce2 extends Terrain {
    public BleuFonce2(int position) {
        super(position);
        super.setPrix(40000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=5000;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=20000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=20000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=60000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=140000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=170000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=200000;
    }


    @Override
    public String toString() {
        return "Rue de la Paix";
    }
}
