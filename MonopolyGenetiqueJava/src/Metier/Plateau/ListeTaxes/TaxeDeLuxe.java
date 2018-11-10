package Metier.Plateau.ListeTaxes;

import Metier.Plateau.ListeTaxes.Taxes;

public class TaxeDeLuxe extends Taxes {

    public TaxeDeLuxe() {
        super(2); //à revoir (position certainement incorrecte)
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "TaxeDeLuxe";
    }
}
