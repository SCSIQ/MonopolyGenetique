package Metier.Plateau.ListeProprietes.ListeTerrains.Rouge;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Rouge2 extends Terrain {
    public Rouge2(int position) {
        super(position);
        super.setPrix(22000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=1800;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=15000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=9000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=25000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=70000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=87500;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=105000;
    }

    @Override
    public String toString() {
        return "Boul. Malesherbes";
    }
}
