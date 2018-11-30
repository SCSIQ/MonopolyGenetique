package Entites;

import Metier.Plateau.Cases;
import javafx.scene.paint.Color;

public class Pion {

    private Joueur joueur;
    private Color couleur;
    private Cases position;
    private boolean goToPrison = false;

    ///////// CONSTRUCTEUR
    public Pion(Joueur joueur, Cases position, Color couleur) {
        this.joueur = joueur;
        this.position = position;
        this.couleur = couleur;
    }

    ///fonction qui fait avancer le pion sur le plateau IHM
    public void avancer(int nombre){
        boolean hasMoved = false;
        for(int i=0 ; i<joueur.getListeCases().size() ; i++){
            if(joueur.getListeCases().get(i).getPosition() == nombre && hasMoved == false){
                this.position = joueur.getListeCases().get(i);
                hasMoved = true;
            }
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public Color getCouleurPion(){
        return couleur ;
    } //renvoie la couleur du pion du joueur

    public Joueur getJoueur() {
        return joueur;
    } //renvoie le joueur

    public Cases getCase() {
        return position;
    } //renvoie la case où est le pion du joueur

    public boolean isGoToPrison() {
        return goToPrison;
    }

    public void setGoToPrison(boolean goToPrison) {
        this.goToPrison = goToPrison;
    }
}
