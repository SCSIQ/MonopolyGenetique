package Metier.Plateau.ListeTaxes;

import Metier.Plateau.Cases;

public abstract class Taxes extends Cases {

    protected int prixTaxe;

    public Taxes(int position) {
        super(position);
    }

    public int getPrixTaxe() {
        return prixTaxe;
    }
}
