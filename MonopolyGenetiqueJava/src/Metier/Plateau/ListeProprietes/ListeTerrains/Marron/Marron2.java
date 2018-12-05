package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron2 extends Terrain {

    public Marron2(int position) {
        super(position);
        super.setPrix(800);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=40;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=200;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=600;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=1800;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=3200;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=4500;
    }

    @Override
    public String toString() {
        return "Rue Lecourbe";
    }
}
