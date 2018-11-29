package Metier.Plateau.ListeCartes;

public abstract class Chance extends CaseCarte {

    public Chance(int position) {
        super(position);
    }

    @Override
    public abstract String toString();
}
