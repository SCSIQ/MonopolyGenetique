package Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;

public class BleuCiel3 extends Terrain {

    public BleuCiel3(int position) {
        super(position);
        super.setPrix(12000);
    }

    @Override
    public void setLoyerSansMaison() {
        super.loyerSansMaison=800;
    }

    @Override
    public void setPrixAjoutMaison() {
        super.prixAjoutMaison=5000;
    }

    @Override
    public void setLoyer1Maison() {
        super.loyer1Maison=4000;
    }

    @Override
    public void setLoyer2Maison() {
        super.loyer2Maison=10000;
    }

    @Override
    public void setLoyer3Maison() {
        super.loyer3Maison=30000;
    }

    @Override
    public void setLoyer4Maison() {
        super.loyer4Maison=45000;
    }

    @Override
    public void setLoyerHotel() {
        super.loyerHotel=60000;
    }

    @Override
    public String toString() {
        return "Avenue de la République";
    }
}
