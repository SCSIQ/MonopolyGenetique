package Metier.Plateau;

import Entites.Joueur;

public abstract class  Cases {

    protected int position ; //0 pour le départ, 1 pour la première case, 2 pour la suivant, etc

    public Cases(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public abstract String toString();
}
