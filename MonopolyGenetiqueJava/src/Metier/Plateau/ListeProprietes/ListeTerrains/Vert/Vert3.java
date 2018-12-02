package Metier.Plateau.ListeProprietes.ListeTerrains.Vert;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Vert3 extends Terrain {
    public Vert3(int position) {
        super(position);
        super.setPrix(32000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=2800;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=20000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=15000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=45000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=100000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=120000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=140000;
    }

    @Override
    public String toString() {
        return "Boul. des Capucines";
    }
}
