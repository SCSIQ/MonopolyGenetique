package Metier.Plateau.ListeCartes;

import Metier.Plateau.Cases;

public abstract class CaseCarte extends Cases {

    public CaseCarte() {
        super(-1);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return null;
    }
}
