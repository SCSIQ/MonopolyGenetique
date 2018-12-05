package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel1 extends Terrain {

    public BleuCiel1(int position) {
        super(position);
        super.setPrix(1000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=60;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=500;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=300;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=900;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=2700;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=4000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=5500;
    }

    @Override
    public String toString() {
        return "Rue de Vaugirard";
    }
}
