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

    public void avancer(int nombre){
        if(position.getPosition() + nombre <= 13){
            for(int i=0 ; i<joueur.getListeCases().size() ; i++){
                if(joueur.getListeCases().get(i).getPosition() == position.getPosition() + nombre){
                    this.position = joueur.getListeCases().get(i);
                }
            }
        }
        else{
            System.out.println("    ne peut pas avancer pour le moment...");
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
