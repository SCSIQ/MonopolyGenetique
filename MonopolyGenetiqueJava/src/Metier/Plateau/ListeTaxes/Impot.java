package Metier.Plateau.ListeTaxes;

import Metier.Plateau.ListeTaxes.Taxes;

public class Impot extends Taxes {

    public Impot(int position) {
        super(position);
        super.prixTaxe=1500;
    }

    @Override
    public String toString() {
        return "Impot sur le Revenu";
    }
}
