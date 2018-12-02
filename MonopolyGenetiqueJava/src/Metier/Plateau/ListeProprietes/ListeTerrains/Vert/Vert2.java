package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert2 extends Terrain {
    public Vert2(int position) {
        super(position);
        super.setPrix(30000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=2600;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=20000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=13000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=39000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=90000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=110000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=127500;
    }


    @Override
    public String toString() {
        return "Avenue Foch";
    }
}
