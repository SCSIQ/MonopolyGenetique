package Metier.Plateau.ListeProprietes;

import Metier.Plateau.ListeProprietes.ServicePublic;

public class Robinet extends ServicePublic {

    public Robinet() {
        super(12);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Robinet";
    }
}
