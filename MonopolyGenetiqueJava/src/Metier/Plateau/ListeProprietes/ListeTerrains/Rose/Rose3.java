package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose3 extends Terrain {

    public Rose3(int position) {
        super(position);
        super.setPrix(1600);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=120;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=600;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=1800;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=5000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=7000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=9000;
    }

    @Override
    public String toString() {
        return "Rue du Paradis";
    }
}
