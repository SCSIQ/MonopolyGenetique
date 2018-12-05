package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge2 extends Terrain {
    public Rouge2(int position) {
        super(position);
        super.setPrix(2200);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=180;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=900;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=2500;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=7000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=8750;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=10500;
    }

    @Override
    public String toString() {
        return "Boul. Malesherbes";
    }
}
