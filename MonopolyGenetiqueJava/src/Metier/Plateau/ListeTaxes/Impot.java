package Metier.Plateau.ListeTaxes;

import Metier.Plateau.ListeTaxes.Taxes;

public class Impot extends Taxes {

    public Impot(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Impot sur le Revenu";
    }
}
