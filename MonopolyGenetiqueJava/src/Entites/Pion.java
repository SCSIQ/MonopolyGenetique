package Entites;

import Metier.Plateau.Cases;
import javafx.scene.paint.Color;

public class Pion {

    private Joueur joueur;
    private Color couleur ;
    private Cases position ;

    ///////// CONSTRUCTEUR
    public Pion(Joueur joueur, Cases position, Color couleur) {
        this.joueur = joueur;
        this.position = position;
        this.couleur = couleur;
    }

    ///fonction qui fait avancer le pion sur le plateau IHM
    public void avancer(int nombre){
        boolean hasMoved = false;
        if(position.getPosition() + nombre <= 15){
            for(int i=0 ; i<joueur.getListeCases().size() ; i++){
                if(joueur.getListeCases().get(i).getPosition() == position.getPosition() + nombre && hasMoved == false){
                    this.position = joueur.getListeCases().get(i);
                    hasMoved = true;
                }
            }
        }
        else{
            System.out.println("    ne peut pas avancer pour le moment...\n        Veuillez attendre une maj");
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
}
