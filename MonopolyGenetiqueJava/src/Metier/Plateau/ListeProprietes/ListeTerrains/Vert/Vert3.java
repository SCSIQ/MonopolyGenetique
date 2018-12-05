package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert3 extends Terrain {
    public Vert3(int position) {
        super(position);
        super.setPrix(3200);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=280;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=2000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1500;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=4500;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=10000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=12000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=14000;
    }

    @Override
    public String toString() {
        return "Boul. des Capucines";
    }
}
