package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose1 extends Terrain {

    public Rose1(int position) {
        super(position);
        super.setPrix(14000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=600;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=5000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=3000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=9000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=27000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=40000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=55000;
    }

    @Override
    public String toString() {
        return "Boul. de la Villette";
    }
}
