package Entites;

import Metier.Plateau.Cases;

public class Pion {

    private Joueur joueur;
    private CouleurPion couleur ;
    private Cases position ;

    public Pion(Joueur joueur, Cases position, CouleurPion couleur) {
        this.joueur = joueur;
        this.position = position;
        this.couleur = couleur;
    }

    public int getPosition(){
        return position.getPosition();
    }

    public void avancer(int nombre){
        //à coder
    }

}
