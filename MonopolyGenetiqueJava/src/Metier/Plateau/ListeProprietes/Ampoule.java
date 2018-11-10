package Metier.Plateau.ListeProprietes;

import Metier.Plateau.ListeProprietes.ServicePublic;

public class Ampoule extends ServicePublic {

    public Ampoule() {
        super(28);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Ampoule";
    }
}
