package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose3 extends Terrain {

    public Rose3(int position) {
        super(position);
        super.setPrix(16000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=1200;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=10000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=6000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=18000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=50000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=70000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=90000;
    }

    @Override
    public String toString() {
        return "Rue du Paradis";
    }
}
