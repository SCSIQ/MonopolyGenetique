package Metier.Plateau.ListeProprietes.ListeTerrains.Jaune;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class Jaune1 extends Terrain {
    public Jaune1(int position) {
        super(position);
        super.setPrix(2600);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=220;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=1500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=1100;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=3300;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=8000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=9750;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=11500;
    }

    @Override
    public String toString() {
        return "Faubourg Saint-Honoré";
    }
}
