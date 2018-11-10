package Metier.Plateau.ListeTaxes;

import Metier.Plateau.ListeTaxes.Taxes;

public class Impot extends Taxes {

    public Impot() {
        super(2); //à revoir (position certainement incorrecte)
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Impot";
    }
}
