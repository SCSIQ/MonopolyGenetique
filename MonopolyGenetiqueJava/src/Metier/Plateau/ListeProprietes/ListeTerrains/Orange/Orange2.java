package Metier.Plateau.ListeProprietes.ListeTerrains.Orange;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Orange2 extends Terrain {

    public Orange2(int position) {
        super(position);
        super.setPrix(18000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=1400;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=10000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=7000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=20000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=55000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=75000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=95000;
    }

    @Override
    public String toString() {
        return "Boul. Saint-Michel";
    }
}
