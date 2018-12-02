package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron1 extends Terrain {

    public Marron1(int position) {
        super(position);
        super.setPrix(6000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=200;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=5000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=3000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=9000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=16000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=25000;
    }

    @Override
    public String toString() {
        return "Boul. de Belleville";
    }
}
