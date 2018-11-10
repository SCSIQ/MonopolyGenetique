package Metier.Plateau;

import Entites.Joueur;

public abstract class  Cases {

    protected int position ; //0 pour le départ, 1 pour la première case, 2 pour la suivant, etc
    private Joueur proprietaire;

    public Cases(int position) {
        this.position = position;
    }

    public abstract int getPosition();

    public abstract String toString();
}
