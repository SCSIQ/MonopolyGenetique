package Entites;

import Metier.Plateau.Cases;
import javafx.scene.paint.Color;

public class Pion {

    private Joueur joueur;
    private CouleurPion couleur ;
    private Cases position ;

    public Pion(Joueur joueur, Cases position, CouleurPion couleur) {
        this.joueur = joueur;
        this.position = position;
        this.couleur = couleur;
    }

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

    public CouleurPion getCouleurPion(){
        return couleur ;
    }
}
