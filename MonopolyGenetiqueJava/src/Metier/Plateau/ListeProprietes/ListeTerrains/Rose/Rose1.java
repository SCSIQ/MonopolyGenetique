package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose1 extends Terrain {

    public Rose1(int position) {
        super(position);
        super.setPrix(14000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=1000;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=10000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=5000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=15000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=45000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=62500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=75000;
    }

    @Override
    public String toString() {
        return "Boul. de la Villette";
    }
}
