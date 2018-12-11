package Metier.Plateau.ListeTaxes;

import Metier.Plateau.ListeTaxes.Taxes;

public class TaxeDeLuxe extends Taxes {

    public TaxeDeLuxe(int position) {
        super(position);
        super.prixTaxe=1500;
    }

    @Override
    public String toString() {
        return "TaxeDeLuxe";
    }
}
