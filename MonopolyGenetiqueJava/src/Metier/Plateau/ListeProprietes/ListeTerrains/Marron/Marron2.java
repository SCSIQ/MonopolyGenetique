package Metier.Plateau.ListeProprietes.ListeTerrains.Marron;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Marron2 extends Terrain {

    public Marron2(int position) {
        super(position);
        super.setPrix(8000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=400;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=5000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=2000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=6000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=18000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=32000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=45000;
    }

    @Override
    public String toString() {
        return "Rue Lecourbe";
    }
}
