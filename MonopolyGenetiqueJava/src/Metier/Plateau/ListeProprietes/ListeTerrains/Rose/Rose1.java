package Metier.Plateau.ListeProprietes.ListeTerrains.Rose;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rose1 extends Terrain {

    public Rose1(int position) {
        super(position);
        super.setPrix(1400);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=100;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=500;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=1500;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=4500;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=6250;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=7500;
    }

    @Override
    public String toString() {
        return "Boul. de la Villette";
    }
}
