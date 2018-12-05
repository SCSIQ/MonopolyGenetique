package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune3 extends Terrain {
    public Jaune3(int position) {
        super(position);
        super.setPrix(2800);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=240;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1200;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=3600;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=8500;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=10250;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=12000;
    }

    @Override
    public String toString() {
        return "Rue Lafayette";
    }
}
