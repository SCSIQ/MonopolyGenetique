package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert1 extends Terrain {
    public Vert1(int position) {
        super(position);
        super.setPrix(3000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=260;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=2000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1300;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=3900;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=9000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=11000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=12750;
    }

    @Override
    public String toString() {
        return "Avenue de Breteuil";
    }
}
