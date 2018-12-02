package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune3 extends Terrain {
    public Jaune3(int position) {
        super(position);
        super.setPrix(28000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=2400;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=15000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=12000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=36000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=85000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=102500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=120000;
    }

    @Override
    public String toString() {
        return "Rue Lafayette";
    }
}
