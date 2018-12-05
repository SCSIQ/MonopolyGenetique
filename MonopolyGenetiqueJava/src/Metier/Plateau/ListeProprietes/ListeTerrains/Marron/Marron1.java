package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron1 extends Terrain {

    public Marron1(int position) {
        super(position);
        super.setPrix(600);
        //setLoyerSansMaison(20);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=20;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=100;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=300;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=900;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=1600;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=2500;
    }

    @Override
    public String toString() {
        return "Boul. de Belleville";
    }
}
