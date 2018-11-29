package Metier.Plateau.ListeCartes;

public abstract class CaisseCommune extends CaseCarte {

    public CaisseCommune(int position) {
        super(position);
    }

    @Override
    public abstract String toString();
}
